package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
 * https://www.youtube.com/watch?v=rP4zdxydE_0
 */
public class B9_PalindromeLinkedList {
	public static void main(String[] args) {
		A1Node head = new A1Node(7);
		head.next = new A1Node(5);
		head.next.next = new A1Node(3);
		head.next.next.next = new A1Node(5);
		head.next.next.next.next = new A1Node(7);

		A1Node mid = getMidNode(head);
		A1Node nNode = mid.next;
		mid.next = null;
		A1Node head2 = reverse(nNode);
		A1Node curr1 = head;
		A1Node curr2 = head2;
		boolean isPalin = true;
		while (curr1 != null && curr2 != null) {
			if (curr1.data != curr2.data) {
				isPalin = false;
				break;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		// Preserving old list
		head2 = reverse(nNode);
		mid.next = head2;

		System.out.println(isPalin);
	}

	private static A1Node reverse(A1Node head) {
		A1Node prev = null;
		A1Node next = null;
		A1Node curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static A1Node getMidNode(A1Node head) {
		A1Node slow = head;
		A1Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
