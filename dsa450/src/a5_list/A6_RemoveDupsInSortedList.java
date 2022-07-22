package a5_list;

import java.util.LinkedList;

/*
 * https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
 * https://www.youtube.com/watch?v=ErSDF5IM1fo - 1st
 * https://www.youtube.com/watch?v=GgLRB2V9R3o - 2nd
 */
public class A6_RemoveDupsInSortedList {
	public static void main(String[] args) {
		// solution1();
		solution2();
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

	private static void solution1() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(5);
		System.out.println(list);
		LinkedList<Integer> ans = new LinkedList<>();
		while (list.size() > 0) {
			int val = list.getFirst();
			list.removeFirst();
			if (ans.size() == 0 || ans.getLast() != val)
				ans.addLast(val);
		}
		System.out.println(ans);
	}
}
