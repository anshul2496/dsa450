package a4_list;

/*
 * https://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/
 */
public class A8_MoveLastElementToFront {
	public static void main(String[] args) {
		A1Node head = new A1Node(1);
		head.next = new A1Node(2);
		head.next.next = new A1Node(3);
		head.next.next.next = new A1Node(4);
		head.next.next.next.next = new A1Node(5);
		print(head);

		A1Node curr = head;
		A1Node prev = null;
		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
		curr.next = head;
		head = curr;
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
