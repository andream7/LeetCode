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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        /**
        使用queue存储每一层的节点（作为根结底）
         */
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        /**
        标记位，标记是正序存还是倒序存
         */
        boolean flag = true;
        // 不为空说明还没有遍历完这棵树
        while (!q.isEmpty()) {
            int size = q.size();
            /**
            List cur 存储当前层的所有节点
             */
            List<Integer> cur = new LinkedList<>();
            int i = 0;
            while (i ++ < size) {
                TreeNode node = q.poll();
                /**
                    如果是正序，把这个节点添加到 cur 的最后，
                    否则，添加到最前面
                 */ 
                if (flag) {
                    cur.add(node.val);
                } else cur.add(0, node.val);

                /**
                把当前节点的左右孩子加入queue，等待下一次遍历
                 */
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }
            flag = !flag;
            res.add(cur);
        }
        return res;
    }
}