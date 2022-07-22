package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
 * https://www.youtube.com/watch?v=lAi11qfSsTM
 */
public class B3_IntersectionOf2Lists {
	public static void main(String[] args) {
		A1Node head1 = new A1Node(3);
		head1.next = new A1Node(2);
		head1.next.next = new A1Node(4);
		head1.next.next.next = new A1Node(5);
		head1.next.next.next.next = new A1Node(6);

		A1Node head2 = new A1Node(9);
		head2.next = head1.next.next;

		A1Node ans = getIntersectionPoint(head1, head2);
		System.out.println(ans.data);
	}

	private static A1Node getIntersectionPoint(A1Node head1, A1Node head2) {
		A1Node tail = head1;
		while (tail.next != null)
			tail = tail.next;
		tail.next = head2;
		A1Node intersection = getIntersectionNode(head1);
		A1Node ans = getStartingPoint(head1, intersection);
		tail.next = null;
		return ans;
	}

	private static A1Node getStartingPoint(A1Node head1, A1Node intersection) {
		A1Node slow = intersection;
		A1Node fast = head1;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	private static A1Node getIntersectionNode(A1Node head1) {
		A1Node slow = head1;
		A1Node fast = head1;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return slow;
		}
		return null;
	}
}
