/**
迭代法反转链表
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        /**
        两个指针，pre指向head的前一个节点，cur指向head
        */
        ListNode pre = null, cur = head;

        /**
        用一个临时变量next来保存cur.next, 然后把cur.next指向pre，
        把pre移动到cur的位置，cur移动到刚才临时变量next的位置；
        然后进行下一轮循环
         */
        ListNode next = cur.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
       
        /**
        最终cur和恶next都指向null，pre指向的是最后一个节点
        返回pre
         */
         return pre;
    }
}