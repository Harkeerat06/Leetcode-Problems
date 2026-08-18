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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        
        for(ListNode temp: lists)
        {
            while(temp!=null)
            {
                pq.offer(temp.val);
                temp= temp.next;
            }
        }
        
        ListNode head= new ListNode();
        ListNode temp= head;
        temp.next= null;

        while(!pq.isEmpty())
        {
            ListNode node= new ListNode(pq.poll());
            temp.next= node;
            temp= node;
        }
        temp.next= null;
        return head.next;
    }
}