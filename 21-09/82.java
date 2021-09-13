/**
把链表中所有重复的部分都删除
 */
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        while (p != null) {
            ListNode q = p.next;
            // q是p的下一个元素
            // q定位到第一个和q不相等的位置
            while (q != null && p.next.val == q.val) {
                q = q.next;
            }
            // 如果q的下一个元素不等于q
            // 就吧p指向p的下一个节点
            if (p.next.next == q) p = p.next;
            // 否则，跳过中间所有重复的q
            else p.next = q;
        }
        return dummy.next;
    }
}