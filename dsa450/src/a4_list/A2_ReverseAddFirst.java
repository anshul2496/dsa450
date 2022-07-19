package a4_list;

/*
 * https://leetcode.com/problems/reverse-linked-list/
 * https://www.youtube.com/watch?v=TOztSNeXZuw
 */
public class A2_ReverseAddFirst {
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

	static A1Node th, tt;

	private static A1Node reverse(A1Node head) {
		A1Node curr = head;
		A1Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = null;
			addFirst(curr);
			curr = next;
		}
		return th;
	}

	private static void addFirst(A1Node curr) {
		if (th == null) {
			th = curr;
			tt = curr;
		} else {
			curr.next = th;
			th = curr;
		}
	}

	private static void print(A1Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
