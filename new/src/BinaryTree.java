import java.util.*;

public class BinaryTree {
	public class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	private Node root;
	private int size;

	BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, false);
	}

	public Node takeInput(Scanner scn, Node parent, boolean isLeftOrRight) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			if (isLeftOrRight == true) {
				System.out.println("Enter the data for left node of " + parent.data);
			} else if (isLeftOrRight == false) {
				System.out.println("Enter the data for right node of " + parent.data);
			}
		}
		int nodedata = scn.nextInt();

		Node nn = new Node(nodedata);
		size++;
		boolean choice = false;
		System.out.println("Do you have left node??");
		choice = scn.nextBoolean();
		if (choice == true) {
			nn.left = takeInput(scn, nn, true);
		}
		System.out.println("Do you have right node??");
		choice = scn.nextBoolean();
		if (choice == true) {
			nn.right = takeInput(scn, nn, false);
		}
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

	public int height() {
		return height(this.root);
	}

	public int height(Node parent) {
		if (parent == null) {
			return -1;
		}
		int left = height(parent.left);
		int right = height(parent.right);
		int high = Math.max(left, right) + 1;
		return high;
	}

	public void preorder() {
		this.preorder(this.root);
	}

	public void preorder(Node parent) {
		if (parent == null) {
			return;
		}
		System.out.print(parent.data + " ");
		preorder(parent.left);
		preorder(parent.right);

	}

	public void postorder() {
		this.postorder(this.root);
	}

	public void postorder(Node parent) {
		if (parent == null) {
			return;
		}
		postorder(parent.left);
		postorder(parent.right);
		System.out.print(parent.data + " ");

	}

	public void inorder() {
		this.inorder(this.root);
	}

	public void inorder(Node parent) {
		if (parent == null) {
			return;
		}
		inorder(parent.left);
		System.out.print(parent.data + " ");
		inorder(parent.right);

	}

//	public void levelOrder() {
//		LinkedList<Node> queue = new LinkedList<>();
//		queue.add(this.root);
//		while (queue.isEmpty() == false) {
//			Node data = queue.removeFirst();
//			System.out.print(data.data + " ");
//			if (data.left != null) {
//				queue.addLast(data.left);
//			}
//			if (data.right != null) {
//				queue.addLast(data.right);
//			}
//		}
//	}

	Node prev;

	boolean isBST() {
		// This question has 2 approches
		// First is traverse the tree in inorder fashion and store the data in
		// arraylist. If arraylist is sorted return true
		// Second approch is keep checking the range of leaf nodes. If range of leaf
		// nodes are not according to bst return false. Here I have coded only this

		return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	
	boolean isBST(Node node, int max, int min) {
		if(node==null) {
			return true;
		}
		if (node.data > max || node.data < min) {
			return false;
		} else if (!isBST(node.left, node.data, min)) {
			return false;
		} else if (!isBST(node.right, max, node.data)) {
			return false;
		}
		return true;
	}

	

	public int diameter() {
		return this.diameter(this.root);
	}

	public int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int fsc = this.height(node.left) + this.height(node.right) + 2;
		int sc = this.diameter(node.left);
		int tc = this.diameter(node.right);
		return Math.max(fsc, Math.max(sc, tc));
	}

	private class Diapair {
		int height;
		int diameter;

		Diapair(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}

		Diapair() {

		}

	}

	public int diameterbtr() {
		return this.diameterbtr(this.root).diameter;
	}

	public Diapair diameterbtr(Node node) {
		if (node == null) {
			Diapair dp = new Diapair(-1, 0);
			return dp;
		}
		Diapair lp = this.diameterbtr(node.left);
		Diapair rp = this.diameterbtr(node.right);
		Diapair result = new Diapair();
		result.height = Math.max(lp.height, rp.height) + 1;
		result.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));
		return result;
	}

	public int sumOfLeafNodes() {
		return this.sumOfLeafNodes(this.root);
	}

	public int sumOfLeafNodes(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int ls = this.sumOfLeafNodes(node.left);
		int rs = this.sumOfLeafNodes(node.right);
		return ls + rs;
	}
	public void invert() {
		this.invert(this.root);
	}
	public void invert(Node node) {
		
		Node t=node.left;
		node.left=node.right;
		node.right=t;
		if(node.left!=null) {
			invert(node.left);
		}
		if(node.right!=null) {
			invert(node.right);
		}
	}
	public void iterativeinorder() {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Node node=this.root;
		while(true) {
			if(node!=null) {
				stack.push(node);
				node=node.left;
			}else {
				if(stack.isEmpty()) {
					break;
				}
				else {
					node=stack.pop();
					ans.add(node.data);
					node=node.right;
				}
			}
		}
	}
	public void iterativepreorder() {
		
		Stack<Node> stack = new Stack<>();
		Node node=this.root;
		stack.push(node);
		while(!stack.isEmpty()) {
			node=stack.pop();
			System.out.println(node.data);
			if(node.right!=null) {
				stack.push(node.right);
			}
			if(node.left!=null) {
				stack.push(node.left);
			}
		}
	}
}
