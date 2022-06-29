package a4_list;

/*
 * https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 * https://www.youtube.com/watch?v=vkyE6HbTJg0
 */
public class A4_DetectLoop {
	public static void main(String[] args) {
		A1Node head = new A1Node(1);
		head.next = new A1Node(2);
		head.next.next = new A1Node(3);
		head.next.next.next = new A1Node(4);
		head.next.next.next.next = new A1Node(5);
		head.next.next.next.next.next = head.next.next;

		boolean isCycle = isCycle(head);
		System.out.println(isCycle);
	}

	private static boolean isCycle(A1Node head) {
		A1Node slow = head;
		A1Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
