/**
算法关键点：归并排序
使用自顶向下形式的归并排序，需要使用系统栈，调用的最大深度是logn，所以需要额外0(logn)的空间。
所以我们需要使用自底向上非递归形式的归并排序算法。
思路如下：
1. 第一次，将整个区间分为若干段，每段长度是2，将每一段内排好序，小数在前，大数在后。
2. 第二次，把区间分为若干段，每段长度是4.
3. 依此类推，直到每段小区间的长度大于等于n为止。
需要注意，当长度n不是2的n次幂时，每次迭代的最后一个区间会比较特殊，长度会小一些，所以这里需要加上指针不为空的判断。

时间复杂度分析：整个链表遍历logn次，每次遍历的复杂度是O(n), 所以总复杂度为O(nlogn)。
空间复杂度分析：整个算法没有使用递归，空间复杂度为O(1)。
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
    public ListNode sortList(ListNode head) {
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n ++;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < n; i *= 2) {
            // 每次归并段的长度，依次为1,2,4,8...n/2
            ListNode cur = dummy;
            for (int j = 1; j + i <= n; j += i * 2) {
                // j代表每一段的开始，每次将两段归并为一个大的有序段
                // p表示第一段起始点，q表示第二段起始点
                ListNode p = cur.next, q = p;
                for (int k = 0; k < i; k ++) {
                    q = q.next;
                }
                // x和y用于计数第一段和第二段归并的节点个数
                int x  = 0, y = 0;
                // 由于链表的长度非2的整数倍时表长会小于i 
                // 所有需要加上q && p进行边界判断
                while (x < i && y < i && p != null && q != null) {
                    if (p.val <= q.val) {
                        cur.next = p;
                        cur = cur.next;
                        p = p.next;
                        x ++;
                    } else {
                        cur.next = q;
                        cur = cur.next;
                        q = q.next;
                        y ++;
                    }
                }

                while (x < i && p != null) {
                    cur.next = p;
                    cur = cur.next;
                    p = p.next;
                    x ++;
                }
                while (y < i && q != null) {
                    cur.next = q;
                    cur = cur.next;
                    q = q.next;
                    y ++;
                }
                // 把排好序的链表尾链接到下一链表的表头，循环完毕后q为下一链表表头
                cur.next = q;
            }
        }
        return dummy.next;
    }
}