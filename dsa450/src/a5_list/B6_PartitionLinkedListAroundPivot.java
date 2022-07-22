package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/partition-a-linked-list-around-a-given-value/1/
 * https://www.youtube.com/watch?v=R9ak6JgWMAw - Segregate nodes over last index
 * https://www.youtube.com/watch?v=sJhUy4ixASE -Segregate Nodes over pivot
 * Geeks for geeks problem is little different(better problem) from pepcoding - Did it!!
 */
public class B6_PartitionLinkedListAroundPivot {
	public static void main(String[] args) {
		A1Node head1 = new A1Node(7);
		head1.next = new A1Node(5);
		head1.next.next = new A1Node(3);
		head1.next.next.next = new A1Node(2);
		head1.next.next.next.next = new A1Node(6);
		print(head1);

		int pivotData = 3;
		A1Node smaller = new A1Node(-1);
		A1Node sp = smaller;
		A1Node larger = new A1Node(-1);
		A1Node lp = larger;
		A1Node curr = head1;
		A1Node pivot = null;
		while (curr != null) {
			if (curr.data == pivotData) {
				pivot = curr;
			} else if (curr.data < pivotData) {
				sp.next = curr;
				sp = sp.next;
			} else {
				lp.next = curr;
				lp = lp.next;
			}
			curr = curr.next;
		}
		sp.next = pivot;
		pivot.next = larger.next;
		lp.next = null;
		A1Node head = smaller.next;
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
