/**
循环推出条件是两个指向链表的指针不相等
（两个指针都指向null时，循环也会退出，满足题目条件）
如果两个指针不为空，就同时各走一步，
如果两者相交（有两种情况：相交于一点或者两者都为null）
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;

        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }

        return A;
    }
}