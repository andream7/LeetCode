/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当前节点为null或者等于p或q，返回当前节点
        if (root == null || root == p || root == q) return root;

        // 递归root的左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q); 
        // 递归root的右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树中有一个为空，返回另一个非空节点
        if (left == null) return right;
        if (right == null) return left;

        // 如果左右子树都不为空，表明p和q分别在左右子树中，
        // 因此当前节点为最近公共祖先
        return root;
    }
}