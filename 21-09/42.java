/**
双指针求最大值
 */
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int lmax = height[l];
        int rmax = height[r];

        int sum = 0;

        while (l < r) {
            // 分别更新左右两边的最大值
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                sum += lmax - height[l];
                l ++;
            } else {
                sum += rmax - height[r];
                r --;
            }
        }
        return sum;
    }
}