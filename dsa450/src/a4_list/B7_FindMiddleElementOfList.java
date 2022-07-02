package a4_list;

/*
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * https://www.youtube.com/watch?v=aiFAbMOHqIc
 */
public class B7_FindMiddleElementOfList {
	public static void main(String[] args) {
		A1Node head1 = new A1Node(7);
		head1.next = new A1Node(5);
		head1.next.next = new A1Node(3);
		head1.next.next.next = new A1Node(2);
		head1.next.next.next.next = new A1Node(6);
		head1.next.next.next.next.next = new A1Node(9);

		A1Node slow = head1;
		A1Node fast = head1;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.data);
	}
}
