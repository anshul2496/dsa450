package interviews;

/*
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * https://www.youtube.com/watch?v=rPbzUW7usJE
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. 
 * The linked list holds the binary representation of a number.
   Return the decimal value of the number in the linked list.
   Input: head = [1,0,1]
	Output: 5
	Explanation: (101) in base 2 = (5) in base 10
 */
public class A2_BinaryToDecimal {
	public static void main(String[] args) {
		A4_Node head = new A4_Node(1);
		head.next = new A4_Node(0);
		head.next.next = new A4_Node(1);
		System.out.println(getDecimal(head));
	}

	private static int getDecimal(A4_Node head) {
		int ans = 0;
		A4_Node curr = head;
		while (curr != null) {
			ans = (ans * 2) + curr.data;
			curr = curr.next;
		}
		return ans;
	}
}

class A4_Node {
	int data;
	A4_Node next;

	public A4_Node(int data) {
		this.data = data;
	}
}