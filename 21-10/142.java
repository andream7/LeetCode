/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // 慢指针一次走一步，快指针一次走两步
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // 如果相遇，说明有环
            if(fast == slow) {
                // 把快指针置于头节点
                fast = head;
                // 相遇的节点就是环的入口节点
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}