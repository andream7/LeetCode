/**
算法：栈
 */
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0, n = s.length();
        char[] sc = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            if (sc[i] == '(') {
                stack.push(i);
            } else {
                // 把已经匹配好的元素移除
                stack.pop();
                // 如果栈已经空了，就把当前位置压入栈，
                // 当作一个新的开始
                if (stack.empty()) stack.push(i);
                // 如果不为空，计算已经完成匹配（已经被移除了）的部分长度
                else res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}

/**
算法关键：动态规划
状态表示：dp[i]表示以下标i结尾的最长合法括号长度，所有以左括号结尾的序列都不是合法括号序列。

我们从前向后扫描，如果遇到了s[i]是右括号，有两种情况：
1. s[i - 1]='(', 很明显dp[i] = dp[i-2] + 2
2. s[i - 1]=')', 我们需要判断i - dp[i-1] - 1的位置是否是左括号，这个是以s[i-1]结尾的最长合法括号序列
的前一个字符，如果这个字符不是左括号，说明当前括号没有合法匹配。
3. 如果是左括号，那么dp[i] = dp[i-1] + 2 + dp[i - dp[i - 1] - 2]. 
分别代表以s[i-1]结尾的最长合法括号序列长度，s[i]的右括号和对应的左括号，s[i]的左括号前面一个位置结尾的最长合法括号序列
 */
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0, n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        char[] sc = s.toCharArray();

        for (int i = 1; i < n; i++) {
            if (sc[i] == ')') {
                if (sc[i - 1] == '(') {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else dp[i] = 2;

                } else if (i - dp[i - 1] - 1 >= 0 && sc[i - dp[i - 1] - 1] == '(') {
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    } else dp[i] = dp[i - 1] + 2;
                    
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

/**
算法：双向扫描，不需要使用额外空间
第一遍从左向右扫描，left和right分别代表当前合法的左括号个数和右括号个数，遇到左括号left ++，遇到右括号right++，
如果right == left，说明遇到一个合法的括号对，更新答案。如果left < right，说明后面怎么匹配都不可能合法了。
但是对于（（（））这样的括号对，得不到正确答案，所以需要从右向左再扫描一次。

 */
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0, n = s.length(), left = 0, right = 0;
        char[] sc = s.toCharArray();
        // 从左向右扫描
        for (int i = 0; i < n; i++) {
            if (sc[i] == '(') left++;
            else right ++;
            if (left == right) res = Math.max(res, left + right);
            if (left < right) {
                left = 0;
                right = 0;
            }
        }

        left = 0; right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sc[i] == ')') right++;
            else left ++;
            if (left == right) res = Math.max(res, left + right);
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return res;
    }
}