import java.util.*;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	private Node root;
	private int size;

	GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeInput(scn, null, 0);
	}

	private Node takeInput(Scanner scn, Node parent, int ithchild) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			System.out.println("Enter the data for " + ithchild + "thchild of " + parent.data);
		}
		int nodedata = scn.nextInt();
		Node nn = new Node(nodedata);
		size++;

		System.out.println("Enter the no. of children");
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			Node child = takeInput(scn, nn, i);
			nn.children.add(child);
		}
		return nn;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node parent) {
		if (parent == null) {
			return;
		}
		System.out.print(parent.data + "=>");
		for (int i = 0; i < parent.children.size(); i++) {
			System.out.print(parent.children.get(i).data + ", ");
		}
		System.out.print("END");
		System.out.println("");
		for (int i = 0; i < parent.children.size(); i++) {
			display(parent.children.get(i));
		}
	}
}
