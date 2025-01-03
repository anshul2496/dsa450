package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 * https://www.youtube.com/watch?v=EKgNMFCShO8
 */
public class A3_ReverseInKGroups {
	public static void main(String[] args) {
		A1Node head = new A1Node(1);
		head.next = new A1Node(2);
		head.next.next = new A1Node(3);
		head.next.next.next = new A1Node(4);
		head.next.next.next.next = new A1Node(5);
		System.out.println("Original list -");
		print(head);
		System.out.println("\nReversed List -");
		A1Node node = reverse(head, 3);
		print(node);
	}

	static A1Node th, tt;

	// My impl. - Here you dont need to do len>=k and again do reverse
//	public static A1Node reverse(A1Node node, int k) {
//        th=null;
//        tt=null;
//        int count=getLength(node);
//        A1Node oh=null;
//        A1Node ot=null;
//        A1Node curr=node;
//        A1Node next=null;
//        while(count>0){
//            int temp=0;
//            th=null;
//            tt=null;
//            while(curr!=null && temp<k){
//                next=curr.next;
//                curr.next=null;
//                addFirst(curr);
//                curr=next;
//                temp++;
//            }
//            if(oh==null){
//                oh=th;
//                ot=tt;
//            }else{
//                ot.next=th;
//                ot=tt;
//            }
//            count=count-k;
//        }
//        return oh;
//    }
	
	private static A1Node reverse(A1Node head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		int len = getLength(head);
		A1Node oh = null, ot = null;
		th = null;
		tt = null;
		A1Node curr = head;
		A1Node next = null;
		while (len >= k) {
			int temp = k;
			while (temp-- > 0) {
				next = curr.next;
				curr.next = null;
				addFirst(curr);
				curr = next;
			}
			if (oh == null) {
				oh = th;
				ot = tt;
			} else {
				ot.next = th;
				ot = tt;
			}
			th = null;
			tt = null;
			len = len - k;
		}
		while (curr != null) {
			next = curr.next;
			curr.next = null;
			addFirst(curr);
			curr = next;
		}
		ot.next = th;
		return oh;
	}

	private static int getLength(A1Node head) {
		int len = 0;
		A1Node temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		return len;
	}

	private static void addFirst(A1Node curr) {
		if (th == null) {
			th = curr;
			tt = curr;
		} else {
			curr.next = th;
			th = curr;
		}
	}

	private static void print(A1Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
