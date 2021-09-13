/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        // 维护左右子树往下延申的最大路径和
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

    // 将左右子树维护的两条最大路径，和该点拼接起来，
    // 就得到这个点向下部分的最长路径
        ans = Math.max(ans, left + root.val + right);
    // 维护从这个点往下延伸的最大路径：
    // 从左右子树中选择权值最大的一条
        return root.val + Math.max(left, right);
    }
}