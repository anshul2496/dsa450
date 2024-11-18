package a5_list;

/*
 * https://practice.geeksforgeeks.org/problems/partition-a-linked-list-around-a-given-value/1/
 * https://www.youtube.com/watch?v=R9ak6JgWMAw - Segregate nodes over last index
 * https://www.youtube.com/watch?v=sJhUy4ixASE -Segregate Nodes over pivot
 * Geeks for geeks problem is little different(better problem) from pepcoding - Did it!!
 */
public class B6_PartitionLinkedListAroundPivot {
	public static void main(String[] args) {
		A1Node head1 = new A1Node(1);
		head1.next = new A1Node(4);
		head1.next.next = new A1Node(3);
		head1.next.next.next = new A1Node(2);
		head1.next.next.next.next = new A1Node(5);
		head1.next.next.next.next.next = new A1Node(2);
		head1.next.next.next.next.next.next = new A1Node(3);
		print(head1);
		print(partition(head1, 3));
	}

	// My GFG Impl.- Took 3 pointers
	public static A1Node partition(A1Node head, int x) {
        if(head==null || head.next==null) return head;
        A1Node dummyS=new A1Node((int)1e8);
        A1Node itrS=dummyS;
        A1Node dummyM=new A1Node((int)1e8);
        A1Node itrM=dummyM;
        A1Node dummyL=new A1Node((int)1e8);
        A1Node itrL=dummyL;
        A1Node curr=head;
        while(curr!=null){
            if(curr.data<x){
                itrS.next=curr;
                itrS=curr;
            }else if(curr.data>x){
                itrL.next=curr;
                itrL=curr;
            }else{
                itrM.next=curr;
                itrM=curr;
            }
            curr=curr.next;
        }
        if(dummyM.next!=null){
            itrS.next=dummyM.next;
            itrM.next=dummyL.next;
            itrL.next=null;
        }else{
            itrS.next=dummyL.next;
            itrL.next=null;
        }
        return dummyS.next;
    }
	
	private static void print(A1Node head) {
		A1Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
