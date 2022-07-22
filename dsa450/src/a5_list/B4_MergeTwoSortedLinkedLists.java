package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
 * https://www.youtube.com/watch?v=mBUcaPvEawI
 */
public class B4_MergeTwoSortedLinkedLists {
	public static void main(String[] args) {
		A1Node head1 = new A1Node(1);
		head1.next = new A1Node(2);
		head1.next.next = new A1Node(3);
		head1.next.next.next = new A1Node(4);
		head1.next.next.next.next = new A1Node(6);

		A1Node head2 = new A1Node(2);
		head2.next = new A1Node(4);
		head2.next.next = new A1Node(5);
		head2.next.next.next = new A1Node(6);

		A1Node dummy = new A1Node(-1);
		A1Node itr = dummy;
		A1Node c1 = head1;
		A1Node c2 = head2;
		while (c1 != null && c2 != null) {
			if (c1.data <= c2.data) {
				itr.next = c1;
				c1 = c1.next;
			} else {
				itr.next = c2;
				c2 = c2.next;
			}
			itr = itr.next;
		}
		itr.next = c1 != null ? c1 : c2;
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
