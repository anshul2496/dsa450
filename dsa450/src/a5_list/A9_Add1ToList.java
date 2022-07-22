package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
 * https://www.youtube.com/watch?v=wU3m025A-cQ
 */
public class A9_Add1ToList {
	public static void main(String[] args) {
		A1Node head = new A1Node(6);
		head.next = new A1Node(5);
		head.next.next = new A1Node(9);
		print(head);
		print(addOne(head));
	}

	public static A1Node addOne(A1Node head) {
		// Reverse
		A1Node revHead = reverse(head);

		// Add 1
		A1Node curr = revHead;
		A1Node prev = null;
		int div = 1;
		while (curr != null) {
			int val = curr.data + div;
			int rem = val % 10;
			div = val / 10;
			curr.data = rem;
			prev = curr;
			curr = curr.next;
		}
		if (div != 0) {
			A1Node newNode = new A1Node(div);
			prev.next = newNode;
		}
		// Reverse back
		return reverse(revHead);
	}

	public static A1Node reverse(A1Node head) {
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
