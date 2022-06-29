package a4_list;

/*
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1/
 * https://www.youtube.com/watch?v=71NqKy7287g
 * Input: Head of following linked list 
	1->2->3->4->NULL 
	Output: Linked list should be changed to, 
	4->3->2->1->NULL
 */
public class A1_ReverseLinkedList {
	public static void main(String[] args) {
		A1Node head = new A1Node(1);
		head.next = new A1Node(2);
		head.next.next = new A1Node(3);
		head.next.next.next = new A1Node(4);
		System.out.println("Original list -");
		print(head);
		System.out.println("\nReversed List -");
		A1Node node = reverse(head);
		print(node);
	}

	private static A1Node reverse(A1Node head) {
		A1Node prev = null;
		A1Node curr = head;
		A1Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}

	private static void print(A1Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}

class A1Node {
	int data;
	A1Node next;

	public A1Node(int data) {
		this.data = data;
	}
}