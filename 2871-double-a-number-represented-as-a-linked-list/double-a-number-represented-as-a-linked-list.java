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
    public ListNode doubleIt(ListNode head) {
        Stack<Integer> nodeValues = new Stack<>();
        int val =0;

        while(head!=null){
            nodeValues.push(head.val);
            head = head.next;
        }

        ListNode last = null;
        while(val !=0 || !nodeValues.isEmpty()){
            last = new ListNode(0, last);

            if(!nodeValues.isEmpty())
            val = val + nodeValues.pop() * 2;

            last.val = val % 10;
            val /= 10;
        }

        return last;
    }
}