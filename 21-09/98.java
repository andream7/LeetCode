/**
在往下遍历子树的过程中，根据父节点更新子树值的大小范围
1. 如果当前节点超过了合理的范围，返回false
2. 否则递归左子树，将左子树的最大值更新为当前节点的值-1；递归右子树，将右子树的最小值更新为当前节点的值+1

时间复杂度：O(N)，每个节点只遍历一次

注意，题目限制，使用Integer会溢出
 */

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

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max){
        if(root == null) return true;

        // 如果与最大或者最小值相等，也是不满足条件的 
        if(root.val >= max || root.val <= min) return false;

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

}