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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // 递归遍历root的左右子树
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode a, TreeNode b){
        // 如果两个节点都为空，说明是对称的
        if(a == null && b == null) return true;
        // 如果两个节点都不为空
        if(a != null && b != null) {
            // 判断当前值是否相等，递归遍历对称的节点
            // 有任何一个不满足都会返回false
            return a.val == b.val && dfs(a.left, b.right) && dfs(a.right, b.left);
        } else {
            return false;
        }
    }
}