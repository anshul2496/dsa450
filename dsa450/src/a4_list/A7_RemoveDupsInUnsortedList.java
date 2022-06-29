package a4_list;

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

		HashMap<Integer, Boolean> map = new HashMap<>();
		A1Node curr = head;
		A1Node dummy = new A1Node(-(int) 1e8);
		A1Node temp = dummy;
		while (curr != null) {
			if (!map.isEmpty() && map.containsKey(curr.data)) {
				curr = curr.next;
			} else {
				map.put(curr.data, true);
			}
			temp.next = curr;
			temp = temp.next;
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
