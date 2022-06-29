package a4_list;

/*
 * https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 * https://www.youtube.com/watch?v=VxOFflTXlXo
 */
public class A5_DeleteLoop {
	public static void main(String[] args) {
		A1Node head = new A1Node(1);
		head.next = new A1Node(2);
		head.next.next = new A1Node(3);
		head.next.next.next = new A1Node(4);
		head.next.next.next.next = new A1Node(5);
		head.next.next.next.next.next = head.next.next;

		// Detect cycle
		A1Node intersection = detectCycle(head);
		System.out.println("Intersection " + intersection.data);

		// Get starting point of the loop
		A1Node startingNode = getStartingNode(intersection, head);
		System.out.println("Cycle starts at " + startingNode.data);

		// Remove loop
		removeLoop(startingNode, head);
		
		print(head);
	}

	private static void print(A1Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	private static void removeLoop(A1Node startingNode, A1Node head) {
		A1Node temp = startingNode;
		while (temp.next != startingNode)
			temp = temp.next;
		temp.next = null;
	}

	private static A1Node getStartingNode(A1Node intersection, A1Node head) {
		A1Node slow = head;
		A1Node fast = intersection;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	private static A1Node detectCycle(A1Node head) {
		A1Node slow = head;
		A1Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return slow;
		}
		return null;
	}
}
