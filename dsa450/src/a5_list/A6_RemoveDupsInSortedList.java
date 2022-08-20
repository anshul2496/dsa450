package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
 * https://www.youtube.com/watch?v=GgLRB2V9R3o
 */
public class A6_RemoveDupsInSortedList {
	public static void main(String[] args) {
		solution2();
	}

	// My GfG implementation - easier I think
	A1Node removeDuplicates(A1Node head) {
		if (head == null || head.next == null)
			return head;
		A1Node dummy = new A1Node((int) 1e8);
		A1Node itr = dummy;
		A1Node curr = head;
		itr.next = curr;
		itr = curr;
		while (curr != null) {
			while (curr.next != null && curr.next.data == curr.data)
				curr = curr.next;
			curr = curr.next;
			itr.next = curr;
			itr = curr;
		}
		return dummy.next;
	}

	private static void solution2() {
		A1Node head = new A1Node(2);
		head.next = new A1Node(2);
		head.next.next = new A1Node(4);
		head.next.next.next = new A1Node(5);
		head.next.next.next.next = new A1Node(5);
		print(head);
		A1Node dummy = new A1Node(-(int) 1e8);
		A1Node itr = dummy;
		A1Node curr = head;
		while (curr != null) {
			while (curr != null && itr.data == curr.data)
				curr = curr.next;
			itr.next = curr;
			itr = itr.next;
			if (curr != null)
				curr = curr.next;
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
