/**
重排链表
step1：通过快慢指针找到链表中点，可以直接用 876.链表的中间结点
step2. 对后半部分链表进行反转，可以直接用 206.反转链表
step3. 将两个链表进行合并，思路类似 21.合并两个有序链表， 这里归并的标准是根据奇偶，需要修改一下
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
    public void reorderList(ListNode head) {
        if (head == null) return;

        // 找出链表的中间节点
        ListNode mid = middleNode(head);

        ListNode left = head;
        // 得到右边链表翻转后的部分
        ListNode right = reverse(mid.next);
        // 反转后mid指向尾节点，设置为空
        mid.next = null;

        // 合并左右两个链表
        head = reorder(left, right);
    }

    // 快慢指针，找出链表的中心节点
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // 迭代法反转链表
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    // 归并两个链表
    public ListNode reorder(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        while (left != null && right != null) {
            t.next = left;
            t = t.next;
            left = left.next;

            t.next = right;
            t = t.next;
            right = right.next;
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