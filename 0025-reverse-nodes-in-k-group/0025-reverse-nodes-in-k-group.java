/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode knode = get(head, k);

        if (knode == null) {
            return head;
        }

        ListNode temp1 = knode.next;

        ListNode temp = head;
        knode.next = null; // so that in reverse function it treat kth node as last

        int itr = 0;

        while (knode != null) {
            ListNode revhead = reverse(temp);

            if(itr == 0){
                head = revhead ;
            }

            knode = get(temp1 , k);

            if (knode != null) {
                temp.next = knode;
                temp = temp1;
                temp1 = knode.next ;
                knode.next = null ;
            }
            itr++;
        }

        temp.next = temp1 ;

        return head;

    }

    public ListNode reverse(ListNode temp) {
        if (temp == null || temp.next == null) {
            return temp;
        }

        ListNode prev = null;
        ListNode first = temp;
        ListNode second = temp.next;

        while (first != null) {
            first.next = prev;
            prev = first;
            first = second;
            if (second != null) {
                second = second.next;
            }
        }

        return prev;
    }

    public ListNode get(ListNode head, int k) {
        ListNode temp = head;

        for (int i = 1; i < k; i++) { // as the count of first node is 1 
            if (temp == null) {
                return temp ;
            }
            temp = temp.next;
        }

        return temp;
    }
}