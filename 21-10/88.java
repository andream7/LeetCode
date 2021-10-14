/**
如果构建一个数组，空间复杂度不是常数。
通过观察题，没有充分利用题目所给的条件，nums1已经开够了足够大，如果直接在nums1上合并，便不需要额外的空间，
而如果从前往后合并，要么会覆盖元素得到错误结果，要么元素整体后移导致时间复杂度上升n^2。
再通过观察，如果**从后往前合并**的方式，则不会覆盖，也不会时间复杂度退化，是理想的解法，时间O(n)，空间常数。
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1, cur = m + n - 1;
        while (p >= 0 && q >= 0) {
            nums1[cur --] = nums1[p] > nums2[q] ? nums1[p --]: nums2[q --];
        }
        // 只需要判断num2中的数是否还有剩余
        while (q >= 0) {
            nums1[cur --] = nums2[q --];
        }
    }
}