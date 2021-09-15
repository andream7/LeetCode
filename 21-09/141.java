/**
算法关键点：快慢指针
两个指针从头开始扫描，第一个指针每次走一步，第二个指针每次走两步。
如果走到null，说明不存在环。如果两个指针相遇，说明存在环。

为什么呢？
假设链表存在环，当第一个指针走到环入口时，第二个指针已经走到环上的某个位置，距离环入口还有x步。
由于第二个指针比第一个指针每次多走一步，所以第一个指针再走x步，两个指针就相遇了。
 */

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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode first = head, second = first.next;

        while (first != null && second != null) {
            if (first == second) return true;
            first = first.next;
            second = second.next;
            if (second != null) second = second.next;
        }

        return false;
    }
}

