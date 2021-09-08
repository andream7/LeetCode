/**
bfs遍历，把每一行遍历到的最后一个加入结果集
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        // 存储中间值序列
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if (i == n - 1) {
                    res.add(cur.val);
                }
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }

        return res;
    }
}