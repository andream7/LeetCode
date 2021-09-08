/**
关键词：桶排序、把数据放置到与下标有关的特定位置上
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        // 把[0, n-1] 中的数移动到 [1, n]的对应位置上
        // 也就是保证第i个位置放置i + 1
        // 数组中第一个不满足该条件的数就是答案
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                // 交换数的下表
                // nums[i] - 1是当前下标的数应该在的下标位置
                swap(nums, i, nums[i] - 1);
            }
        }
        // 查找第一个不满足规则的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 给的序列是一个连续的序列，返回比最大值还大的数
        return nums.length + 1;
    }
    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}