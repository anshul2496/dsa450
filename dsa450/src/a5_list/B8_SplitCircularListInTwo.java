package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1
 * https://www.youtube.com/watch?v=VdGIR91xlaM
 */
public class B8_SplitCircularListInTwo {
	public static void main(String[] args) {
		A1Node head = new A1Node(7);
		head.next = new A1Node(5);
		head.next.next = new A1Node(3);
		head.next.next.next = new A1Node(2);
		head.next.next.next.next = new A1Node(6);
		head.next.next.next.next.next = head;
	}

	public Pair<A1Node, A1Node> splitList(A1Node head) {
		if (head == null || head.next == head)
			return new Pair<A1Node, A1Node>(head, head);

		// Get Intersection
		A1Node intersection = getIntersection(head);

		// Get starting point
		A1Node sp = getStartingPoint(head, intersection);

		// Remove loop
		A1Node curr = sp;
		while (curr.next != sp) {
			curr = curr.next;
		}
		curr.next = null;

		// Get midle element
		A1Node mid = getMiddle(head);

		// Divide into two
		A1Node head2 = mid.next;
		mid.next = head;
		curr.next = head2;
		Pair<A1Node, A1Node> ans = new Pair<A1Node, A1Node>(head, head2);
		return ans;
	}

	public A1Node getMiddle(A1Node head) {
		A1Node slow = head;
		A1Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public A1Node getStartingPoint(A1Node head, A1Node intersection) {
		A1Node slow = head;
		A1Node fast = intersection;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public A1Node getIntersection(A1Node head) {
		A1Node slow = head;
		A1Node fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		return slow;
	}
}

class Pair<F, S> {
	public F first;
	public S second;

	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}
}
