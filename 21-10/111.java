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
    public int minDepth(TreeNode root) {
        // 边界条件，到叶子节点就返回null
        if (root == null) return 0;
        // 非空就分别递归左右子树
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // 任意一个节点先到叶子节点，就证明当前深度是最小深度
        // 返回结果（节点数量）
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        // 如果还没到底，返回更小深度的分支
        return Math.min(left, right) + 1;
    }
}