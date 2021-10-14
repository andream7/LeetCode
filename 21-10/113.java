/**
这道题目和 Path Sum 基本一样，不同点在于需要把所有路径记录下来。
 */

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
    Stack<Integer> path = new Stack();
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        // 减去当前root节点的值
        sum -= root.val;
        // 把当前节点放入path
        path.push(root.val);
        if(root.left == null && root.right == null) {
            // 如果是一条符合条件的path，更新结果集
            if(sum == 0) 
                res.add(new ArrayList(path));
        }
        // 如果没有遍历完，就分别遍历左右子树
        if(root.left != null) pathSum(root.left, sum);
        if(root.right != null) pathSum(root.right, sum);
        // 把当前节点出队，恢复现场
        path.pop();
        return res;
    }
}