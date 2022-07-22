package a5_list;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
 * https://www.youtube.com/watch?v=7pgs-wT5d4c
 */
public class A7_RemoveDupsInUnsortedList {
	public static void main(String[] args) {
		A1Node head = new A1Node(5);
		head.next = new A1Node(2);
		head.next.next = new A1Node(2);
		head.next.next.next = new A1Node(4);
		head.next.next.next.next = new A1Node(5);
		print(head);
		print(removeDuplicates(head));
	}

	public static A1Node removeDuplicates(A1Node head) {
		if (head == null || head.next == null)
			return head;
		HashMap<Integer, Boolean> map = new HashMap<>();
		A1Node dummy = new A1Node(-(int) 1e8);
		A1Node itr = dummy;
		A1Node curr = head;
		while (curr != null) {
			while (curr != null && map.containsKey(curr.data))
				curr = curr.next;
			if (curr != null)
				map.put(curr.data, true);
			itr.next = curr;
			itr = itr.next;
			if (curr != null)
				curr = curr.next;
		}
		return dummy.next;
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
