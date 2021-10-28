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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 边界条件
        if (root == null) return false;
        // 递归判断当前树与子树
        // 递归判断当前树是左子树与子树
        // 递归判断当前树的右子树与子树
        return isSub(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSub(TreeNode s, TreeNode t) {
        // s中当前节点应该和t中当前节点位置是同步的并且值相同
        if (s == null && t == null) return true;
        // 有一个先到达叶子节点，匹配失败
        if (s == null || t == null) return false;
        // 匹配过程中任意一个节点不相等，匹配失败
        if (s.val != t.val) return false;
        // 当前节点匹配成功
        // 递归左右子节点
        // 只要有一个匹配失败，返回的都是false
        return isSub(s.left, t.left) && isSub(s.right, t.right);
    }
}