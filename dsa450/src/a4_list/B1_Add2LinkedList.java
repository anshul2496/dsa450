package a4_list;

/*
 * https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
 * https://www.youtube.com/watch?v=pmS2GAlRNNk
 */
public class B1_Add2LinkedList {
	public static void main(String[] args) {
		A1Node head1 = new A1Node(4);
		head1.next = new A1Node(5);

		A1Node head2 = new A1Node(3);
		head2.next = new A1Node(4);
		head2.next.next = new A1Node(5);

		A1Node head = addTwoLinkedList(head1, head2);
		print(head);
	}

	private static A1Node addTwoLinkedList(A1Node head1, A1Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		// Reverse
		A1Node c1 = reverse(head1);
		A1Node c2 = reverse(head2);

		// Perform Addition
		int carry = 0;
		A1Node dummy = new A1Node(-1);
		A1Node itr = dummy;
		while (c1 != null || c2 != null || carry != 0) {
			int sum = (c1 != null ? c1.data : 0) + (c2 != null ? c2.data : 0) + carry;
			int newVal = sum % 10;
			carry = sum / 10;
			itr.next = new A1Node(newVal);
			itr = itr.next;
			if (c1 != null)
				c1 = c1.next;
			if (c2 != null)
				c2 = c2.next;
		}

		// Reverse New linked list
		A1Node head = reverse(dummy.next);
		return head;
	}

	private static A1Node reverse(A1Node head) {
		A1Node curr = head;
		A1Node prev = null;
		A1Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static void print(A1Node head) {
		A1Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
