
public class BST {
	public class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	BST(int[] arr) {
		this.root = this.construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node nn = new Node();
		nn.data = arr[mid];
		nn.left = construct(arr, lo, mid - 1);
		nn.right = construct(arr, mid + 1, hi);
		return nn;

	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node parent) {
		if (parent == null) {
			return;
		}
		if (parent.left != null) {
			System.out.print(parent.left.data + "=>");
		} else {
			System.out.print("END=>");
		}

		System.out.print(parent.data);

		if (parent.right != null) {
			System.out.print("<=" + parent.right.data);
		} else {
			System.out.print("<=END");
		}
		System.out.println("");
		display(parent.left);
		display(parent.right);
	}

	public boolean search(int data) {
		return this.search(this.root, data);
	}

	public boolean search(Node parent, int data) {
		if (parent == null) {
			return false;
		}

		if (parent.data > data) {
			return this.search(parent.left, data);
		} else if (parent.data < data) {
			return this.search(parent.right, data);
		} else {
			return true;
		}

	}

	public void add(int data) {
		this.add(this.root, data);
	}

	private void add(Node parent, int data) {
		if (data > parent.data) {
			if (parent.right == null) {
				Node nn = new Node();
				nn.data = data;
				parent.right = nn;
			} else {
				add(parent.right, data);
			}
		} else {
			if (parent.left == null) {
				Node nn = new Node();
				nn.data = data;
				parent.left = nn;
			} else {
				add(parent.left, data);
			}
		}
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node parent) {
		if (parent.right != null) {
			return max(parent.right);
		} else {
			return parent.data;
		}

	}

	public void remove(int item) {
		this.remove(this.root, null, false, item);
	}

	private void remove(Node node, Node parent, boolean ilc, int item) {
		if (node == null) {
			return;
		}
		if (node.data > item) {
			this.remove(node.left, node, true, item);
		} else if (node.data < item) {
			this.remove(node.right, node, false, item);
		} else {
			if (node.left == null && node.right == null) {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (node.left == null && node.right != null) {
				if (ilc) {
					parent.left = node.right;

				} else {
					parent.right = node.right;
				}
			} else if (node.right == null && node.left != null) {
				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			}
			else if(node.left!=null&&node.right!=null) {
				node.data=this.max(node.left);
				remove(node.left,node,true,node.data);
			}
		}
	}
}
