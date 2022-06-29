package a4_list;

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

		// Reverse
		A1Node curr = head;
		A1Node next = null;
		A1Node prev = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;

		// Add 1
		int sum = 0;
		int carry = 1;
		curr = head;
		while (curr != null) {
			sum = curr.data + carry;
			int newVal = sum % 10;
			carry = sum / 10;
			curr.data = newVal;
			curr = curr.next;
		}

		// Reverse back
		curr = head;
		prev = null;
		next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		print(head);
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
