package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1
 * Cannot be done on gfg practice. Parameters not correct. Do in Rev
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

		A1Node slow = head;
		A1Node fast = head.next;
		while (fast != head && fast.next != head) {
			slow = slow.next;
			fast = fast.next.next;
		}
		A1Node head1 = head;
		A1Node head2 = slow.next;
		slow.next = head1;
		A1Node curr = head2;
		while (curr.next != head) {
			curr = curr.next;
		}
		curr.next = head2;
		
		// You cant print because the new lists are also cyclic
	}
}
