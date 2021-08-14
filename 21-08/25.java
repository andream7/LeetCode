class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode tail = head;

        for (int i = 0; i < k; i ++) {
            if (tail == null) return head;
            tail = tail.next;
        }
        // tail是反转部分的后一个节点
        // newHead是反转后新的节点
        ListNode newHead = reverse(head, tail); // [ )

        // head在反转后变成的反转部分的最后一个节点
        // 递归下一个反转区间
        // head.next连接递归调用后的头节点
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

    // 与206题的实现一致
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null, next = null;

        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}