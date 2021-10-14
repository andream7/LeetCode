/**
算法：dp
如果s[i : j]为回文串，那么一定满足s[i + 1 : j - 1]是回文串，并且s[i] == s[j];
状态转移方程： dp[l][r] = dp[l + 1][r - 1] && (s[l] == s[r]);
 */

class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[1010][1010];

        int n = s.length();
        // start记录起点，length记录最大长度
        int start = 0, length = 0;
        // 枚举长度
        for (int len = 1; len <= n; len ++) {
            // 枚举起点
            for (int i = 0; i + len - 1 < n; i++) {
                int l = i, r = i + len - 1;
                // 只有一个字母，是回文串
                if (len == 1) dp[i][i] = true;
                else if (len == 2) dp[l][r] = s.charAt(l) == s.charAt(r);
                else {
                    dp[l][r] = dp[l + 1][r - 1] && (s.charAt(l) == s.charAt(r));
                }
                if (dp[l][r] && r - l + 1 >= length) {
                    length = r - l + 1;
                    start = l;
                }
            }
        }
        return s.substring(start, start + length);
    }
}