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
 /**
 递归
 递归算法比较简单，就根据中序遍历的过程，先遍历左子树，再遍历当前根，然后遍历右子树。
 递归函数的中止条件是当前结点为空，同时当遍历当前结点时，将该点加入遍历数组即可。
  */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}

/**
迭代

递归函数实现的过程其实就是系统帮我们调用栈的过程，所以如果换为迭代算法来写，我们只需要自己模拟实现一个栈。
递归的实现也可以反映成一棵树，就是所谓的递归树，当我们调用递归函数的时候，其实有两个过程，一个是向下的递的过程，然后再是向上的归的过程。递归函数很好地封装了这一点，然而当我们用迭代算法时，需要自己去模拟递和归的过程。

遍历是，我们需要将所有左子树链上的所有点放入栈中，该过程即为递。
然后取出栈顶，加入遍历数组，之后再放入右子树，同时注意这里的右子树指的是整个右子树的左子树链。直到遍历完所有结点。
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        while (root != null || !stk.isEmpty()) {
            // 一直遍历左子树到叶子节点
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 弹出栈顶元素
            root = stk.pop();
            // 加入结果集
            res.add(root.val);
            // 遍历右子树
            root = root.right;
        }
        return res;
    }
}
