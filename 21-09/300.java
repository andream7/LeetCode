/**
dps数组
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // 最短的长度是1
        int max = 1;
        // dp数组存储以每一项为结尾的最长递增子序列的长度
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 0; i < len; i++) {
            // j代表i前面的所有元素
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    // dp[j]加上当前i这个长度，也就是加一
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
           max = Math.max(dp[i], max); 
        }
        return max;
    }
}