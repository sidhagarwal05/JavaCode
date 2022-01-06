package LinkedList;
import java.util.HashSet;
import java.util.Set;

public class LinkedList1 {
	class Node {
		int data;
		Node next;
	}

	public int data;
	private int size;
	Node head;
	Node tail;

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void atLast(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		if (size >= 1) {
			tail.next = nn;
		}
		if (size == 0) {
			head = nn;
			tail = nn;
			size++;
		} else {
			tail = nn;
			size++;
		}
	}

	public void atFirst(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = head;

		if (size == 0) {
			head = nn;
			tail = nn;
			size++;
		} else {
			head = nn;
			size++;
		}
	}

	public int getFirst() {
		return this.head.data;
	}

	public int getLast() {
		return this.tail.data;
	}

	public int getAt(int index) {
		Node temp = head;
		for (int i = 1; i <= index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private Node getNodeAt(int index) {
		Node temp = head;
		for (int i = 1; i <= index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void addNodeAt(int index, int data) {
		if (index == 0) {
			atFirst(data);
		} else if (index == size) {
			atLast(data);
		} else {
			Node temp = this.getNodeAt(index - 1);
			Node nn = new Node();
			nn.data = data;
			nn.next = this.getNodeAt(index);
			temp.next = nn;
			size++;
		}

	}

	public int removeFirst() {
		int data = head.data;
		head = head.next;

		return data;

	}

	public int removeLastNode() {
		Node temp1 = this.getNodeAt(this.size - 1);
		int data = temp1.data;
		Node temp = this.getNodeAt(this.size - 2);
		temp.next = null;
		tail = temp;
		return data;
	}

	public int removeAtNode(int index) {
		Node temp1 = this.getNodeAt(index);
		int data = temp1.data;
		Node temp = this.getNodeAt(index - 1);
		temp.next = temp1.next;
		temp1.next = null;
		return data;
	}

	public void removeDuplicates() {
		Node temp1 = this.head;
		Node temp2 = this.head.next;
		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				Node temp3 = temp2.next;
				temp1.next = temp3;
				temp2 = temp3;

			} else {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}

	}

	public void removeDuplicates2() {
		Node temp1 = this.head;
		Node temp2 = null;
		Set<Integer> set = new HashSet<Integer>();
		while (temp1 != null) {
			if (set.contains(temp1.data)) {
				Node temp3 = temp1.next;
				temp2.next = temp3;
				temp1 = temp3;
			} else {
				set.add(temp1.data);
				temp2 = temp1;
				temp1 = temp1.next;
			}
		}
	}

	public void reverse() {
		Node prev = null;
		Node current = this.head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		Node temp = head;
		head = tail;
		tail = temp;

	}

	public void add1() {
		this.reverse();
		int carry = 1;
		Node temp = this.head;
		while (temp != null) {
			int val = temp.data + carry;
			temp.data = val % 10;
			carry = val / 10;
			temp = temp.next;
		}
		if (carry != 0) {
			this.atLast(carry);
		}
		this.reverse();

	}

	public LinkedList1 add2num(LinkedList1 first, LinkedList1 second) {
		LinkedList1 nn = new LinkedList1();
		first.reverse();
		second.reverse();
		Node firstNode = first.head;
		Node secondNode = second.head;
		int carry = 0;
		while (firstNode != null && secondNode != null) {
			int val = firstNode.data + secondNode.data + carry;
			nn.atLast(val % 10);
			carry = val / 10;
			firstNode = firstNode.next;
			secondNode = secondNode.next;
		}
		if (firstNode != null) {
			while (firstNode != null) {
				int val = firstNode.data + carry;
				nn.atLast(val % 10);
				carry = val / 10;
				firstNode = firstNode.next;
			}
		} else if (secondNode != null) {
			while (secondNode != null) {
				int val = secondNode.data + carry;
				nn.atLast(val % 10);
				carry = val / 10;
				secondNode = secondNode.next;
			}
		}

		if (carry != 0) {
			nn.atLast(carry);
		}
		nn.reverse();
		return nn;

	}

	public LinkedList1 merge2sortedLinkedList1(LinkedList1 one, LinkedList1 two) {
		LinkedList1 nn2 = new LinkedList1();
		Node temp1 = one.head;
		Node temp2 = two.head;
		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				nn2.atLast(temp1.data);
				temp1 = temp1.next;
			} else {
				nn2.atLast(temp2.data);
				temp2 = temp2.next;
			}
		}
		while (temp1 != null) {
			nn2.atLast(temp1.data);
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			nn2.atLast(temp2.data);
			temp2 = temp2.next;
		}

		return nn2;

	}

	public Node middle(Node head,Node tail) {
		Node fast = head;
		Node slow = head;
		while (fast.next != tail && fast != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public LinkedList1 mergeSortList(Node head,Node tail) {
		if(head==tail) {
			LinkedList1 br=new LinkedList1();
			br.atLast(tail.data);
			return br;
		}
		Node middle=middle(head,tail);
		
		LinkedList1 fsh=mergeSortList(head,middle);
		LinkedList1 sch=mergeSortList(middle.next,tail);
		LinkedList1 nn1= merge2sortedLinkedList1(fsh,sch);
		return nn1;
		
	}
}
