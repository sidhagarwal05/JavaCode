import java.util.*;

class Node {
    public int data;
    public Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // This function gets two arguments - the head pointers of the two linked lists
    // Return the node which is the intersection point of these linked lists
    // It is assured that the two lists intersect
    Node intersectionOfTwoLinkedLists(Node l1, Node l2) {
    	Node ll1=l1;
    	int size1=0;
    	Node ll2=l2;
    	int size2=0;
    	while(ll1!=null) {
    		ll1=ll1.next;
    		size1++;
    	}
    	while(ll2!=null) {
    		ll2=ll2.next;
    		size2++;
    	}
    	ll1=l1;
    	ll2=l2;
    	int d=0;
    	if(size1>size2) {
    		d=size1-size2;
    		while(d!=0) {
    			ll1=ll1.next;
    		}
    	}
    	else {
    		d=size2-size1;
    		while(d!=0) {
    			ll2=ll2.next;
    		}
    	}
    	while(ll1!=null) {
    		if(ll1==ll2) {
    			return ll2;
    		}
    		ll1=ll1.next;
    		ll2=ll2.next;
    		
    	}
    	
		return l2;
        /* Code here */
    }

}

/*
*
*
*   You do not need to refer or modify any code below this. 
*   Only modify the above class definition.
*	Any modications to code below could lead to a 'Wrong Answer' verdict despite above code being correct.
*	You do not even need to read or know about the code below.
*
*
*
*/

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static Node buildList(HashMap<Integer, Node> hash) {
        int x = sc.nextInt();
        Node head = new Node(x);
        Node current = head;
        hash.put(x, head);
        while (x != -1) {
            x = sc.nextInt();
            if (x == -1)
                break;
            Node n = new Node(x);
            hash.put(x, n);
            current.next = n;
            current = n;
        }
        current.next = null;
        return head;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        HashMap<Integer, Node> hash = new HashMap<Integer, Node>();
        Node l1 = buildList(hash);

        Node l2 = null;
        int x = sc.nextInt();
        l2 = new Node(x);
        Node temp = l2;

        while (x != -1) {
            x = sc.nextInt();
            if (x == -1)
                break;
            if (hash.containsKey(x)) {
                temp.next = hash.get(x);
                break;
            }
            Node n = new Node(x);
            temp.next = n;
            temp = n;
        }

        System.out.print("L1 - ");
        printLinkedList(l1);
        System.out.print("L2 - ");
        printLinkedList(l2);

        Solution s = new Solution();

        Node intersectionPoint = s.intersectionOfTwoLinkedLists(l1, l2);
        System.out.println("Intersection at node with data = " + intersectionPoint.data);

    }
}
