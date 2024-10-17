package b2_heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
 * https://www.youtube.com/watch?v=E5WSILx1q0Q
 * https://www.youtube.com/watch?v=jhWT8qal1SI
 */
public class A9_MergeKSortedLinedLists {
	public static void main(String[] args) {
		Node n1 = new Node(13);
		n1.next = new Node(26);
		n1.next.next = new Node(30);
		n1.next.next.next = new Node(31);
		n1.next.next.next.next = new Node(36);
		n1.next.next.next.next.next = new Node(37);
		n1.next.next.next.next.next.next = new Node(47);
		Node n2 = new Node(4);
		n2.next = new Node(24);
		n2.next.next = new Node(28);
		n2.next.next.next = new Node(37);
		n2.next.next.next.next = new Node(41);
		n2.next.next.next.next.next = new Node(50);
		List<Node> arr = new ArrayList<>();
		arr.add(n1);
		arr.add(n2);
		Node ans = mergeKLists(arr);
		while (ans != null) {
			System.out.print(ans.data + " ");
			ans = ans.next;
		}
	}

	static Node mergeKLists(List<Node> arr) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
			return a.data - b.data;
		});
		for (int i = 0; i < arr.size(); i++) {
			pq.add(arr.get(i));
		}
		Node root = null;
		Node temp = null;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (temp == null) {
				temp = node;
				root = temp;
			} else {
				temp.next = node;
				temp = temp.next;
			}
			node = node.next;
			if (node != null) {
				pq.add(node);
			}
		}
		return root;
	}
}

class Node {
	int data;
	Node next;

	Node(int key) {
		data = key;
		next = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

}
