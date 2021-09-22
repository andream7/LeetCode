/**
算法关键点：动态规划
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 从1到amount进行迭代
        for (int curAmount = 1; curAmount <= amount; curAmount ++) {
            // 枚举每一个面值的硬币
            for (int coin: coins) {
                int leftAmount = curAmount - coin;
                // 注意第二个条件
                if (leftAmount < 0 || dp[leftAmount] == Integer.MAX_VALUE) continue;

                // 更新枚举到当前curamount需要的硬币个数
                dp[curAmount] = Math.min(dp[leftAmount] + 1, dp[curAmount]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}