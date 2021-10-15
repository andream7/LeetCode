/**
定义数组 f[i]f[i] 表示上 i 级台阶的方案数，则枚举最后一步是上1级台阶，还是上2级台阶，所以有：
f[i]=f[i−1]+f[i−2]
 */
class Solution {
    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        // 第0和di1级的方案数均为1
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}

// 可以通过两个变量保存中间状态, f3 = f1 + f2; f1 = f2; f2 = f3. 确保O(1)的空间

