/**
双指针

1. 创建虚拟结点dummy，dummy指向head.next
2. 指针first，second初始化均指向dummy，first指针走n步，first,second指针同时向后走，直到first走到末尾时终止
3. 这样,second就指向了要删除结点的前一个结点
4. 让前一个结点指向删除结点的后一个结点即可
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 设置虚拟头节点
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode first = dummy, second = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        // first遍历到尾节点
        // second指向的就是倒数第n个节点的位置
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}