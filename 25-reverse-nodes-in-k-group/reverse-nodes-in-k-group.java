/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int times = count / k;
        return reverse(head, k, times);
    }

    public ListNode reverse(ListNode head, int k, int t) {
        if (t == 0)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;
        for (int i = 0; i < k; i++) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head.next = reverse(curr, k, t - 1);
        return prev;
    }
}