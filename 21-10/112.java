// 递归，自顶向下从根节点往叶节点走，每走过一个节点，就让 sum 减去该节点的值，则如果走到某个叶节点时，sum 恰好为0，则说明从根节点到这个叶节点的路径上的数的和等于 sumsum。
// 只要找到一条满足要求的路径，递归即可返回。

// 时间复杂度分析：每个节点仅被遍历一次，且递归过程中维护 sum 的时间复杂度是 O(1)，所以总时间复杂度是 O(n)。

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
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        else if (root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
   
    }
}