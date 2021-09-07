/**
二分查找模板题
 */
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        // 处理边界情况
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;

        // 查找旋转点
        int cutoff = -1;
        for (int i = 0; i < n - 1; i ++) {
            if (nums[i] > nums[i + 1]) {
                cutoff = i;
                break;
            }
        }

        int left = find(nums, 0, cutoff, target);
        int right = find(nums, cutoff + 1, n - 1, target);

        return left == -1 ? right : left;
    }

    // 二分查找模板
    public int find(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        // 如果没有查找到就返回-1
        return -1;
    }
}