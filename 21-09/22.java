/**
算法关键点：dfs递归
直接生成合法的括号序列：
1. 可以放置左括号的条件是：当前左括号的数量不超过n
2. 可以放置右括号的条件是：当前右括号的数目不超过左括号

该问题是经典的：卡特兰数
 */
class Solution {
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        dfs(0, 0, n, "");
        return res;
    }

    // l表示已经放置的左括号个数，l表示已经放置的右括号个数
    // n表示括号对数，path代表当前这次递归产生的括号序列
    public void dfs(int l, int r, int n, String path){
        if(l == n && r == n) {
            res.add(path);
            return;
        }
        // 放置左括号的条件 l<n
        if(l < n) dfs(l + 1, r, n, path + "(");
        // 放置右括号的条件r<l
        if(r < l) dfs(l, r + 1, n, path + ")");
    }
}