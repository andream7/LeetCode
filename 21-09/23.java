/**
把所有节点加入最小堆中（重写compare方法），再依次取出创建一个新的链表。
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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode head : lists) {
            while (head != null) {
                q.offer(head);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (q.size() > 0) {
            head.next = q.poll();
            head = head.next;
            if (q.size() == 0) {
                head.next = null;
            }
        }
        return dummy.next;
    }
}