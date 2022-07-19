 package a4_list;

/*
 * https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1
 * https://www.youtube.com/watch?v=HUFibUCDt0U
 * Watch video if you want to see how O(nlogn) comes.
 */
public class B5_MergeSortLinkedLists {
	public static void main(String[] args) {
		A1Node head1 = new A1Node(7);
		head1.next = new A1Node(5);
		head1.next.next = new A1Node(3);
		head1.next.next.next = new A1Node(4);
		head1.next.next.next.next = new A1Node(6);
		print(head1);

		A1Node ans = mergeSort(head1);
		print(ans);
	}

	private static A1Node mergeSort(A1Node head) {
		if (head == null || head.next == null)
			return head;
		A1Node mid = getMidElement(head);
		A1Node nNode = mid.next;
		mid.next = null;
		A1Node l1 = mergeSort(head);
		A1Node l2 = mergeSort(nNode);
		return merge(l1, l2);
	}

	private static A1Node merge(A1Node l1, A1Node l2) {
		if (l1 == null || l2 == null)
			return l1 != null ? l1 : l2;
		A1Node c1 = l1;
		A1Node c2 = l2;
		A1Node dummy = new A1Node(-1);
		A1Node itr = dummy;
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
		return dummy.next;
	}

	private static A1Node getMidElement(A1Node head) {
		A1Node slow = head;
		A1Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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
