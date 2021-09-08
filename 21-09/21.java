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
    public ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                t.next = left;
                t = t.next;
                left = left.next;
            } else {
                t.next = right;
                t = t.next;
                right = right.next;
            }
        }

        if (left != null) {
            t.next = left;
        }
        if (right != null) {
            t.next = right;
        }
        return dummy.next;
    }
}