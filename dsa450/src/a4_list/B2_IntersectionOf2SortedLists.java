package a4_list;

/*
 * https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
 */
public class B2_IntersectionOf2SortedLists {
	public static void main(String[] args) {
		A1Node head1 = new A1Node(1);
		head1.next = new A1Node(2);
		head1.next.next = new A1Node(3);
		head1.next.next.next = new A1Node(4);
		head1.next.next.next.next = new A1Node(6);

		A1Node head2 = new A1Node(2);
		head2.next = new A1Node(4);
		head2.next.next = new A1Node(6);
		head2.next.next.next = new A1Node(6);

		A1Node dummy = new A1Node(-1);
		A1Node itr = dummy;
		A1Node curr1 = head1;
		A1Node curr2 = head2;

		while (curr1 != null && curr2 != null) {
			if (curr1.data < curr2.data)
				curr1 = curr1.next;
			else if (curr1.data > curr2.data)
				curr2 = curr2.next;
			else {
				itr.next = new A1Node(curr1.data);
				itr = itr.next;
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
		}
		print(dummy.next);
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
