class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = -1, right = -1;
        int sum = 0, minLen = Integer.MAX_VALUE;

        while (left <= right) {
            // 还没达到sum的值
            if (sum < target) {
                // 移动右指针
                right ++;
                // 判断right是否越界
                if (right >= nums.length) {
                    break;
                }
                // sum加上right所指的元素
                sum += nums[right];
            } else {
                // 已经超过的sum的值
                // 判断是否需要更新最短长度
                // 移动左指针
                if (right - left < minLen) {
                    minLen = right - left;
                }
                left ++;
                if (left > right) break;
                // sum减去left所指的元素
                sum -= nums[left];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}