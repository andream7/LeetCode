/**
算法关键点：递归建树
递归建立整棵二叉树：先创建左右子树，然后创建根结底，并让指针指向两棵子树。
具体步骤如下：
1. 先利用前序遍历找到根结底（前序遍历的第一个数，就是根结底）
2. 在中序遍历中找到根结底的位置k，k的左边是左子树的中序遍历，右边是右子树的中序遍历
3. 假设左子树的中序遍历的长度是l，则在前序遍历中，根节点后面的l个数，是左子树的前序遍历，剩下的是右子树的前序遍历
4. 有了左右子树的前序遍历和中序遍历，我们可以先递归创建出左右子树，再创建根节点

时间复杂度分析:
在初始化时，用hashmap记录每个值在中序遍历中的位置，这样我们在递归到每个节点时，
中序遍历中查找根结底位置的操作只需要O(1)的时间。
创建每个节点的时间是O(1)，因此总时间复杂度是O(n)。
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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 存储中序遍历每个节点的位置
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfs(int[] pre, int[] in, int pl, int pr, int il, int ir) {
        // 退出的边界条件
        if (pl > pr) return null;

        // 根结底是前序遍历最左边的节点
        TreeNode root = new TreeNode(pre[pl]);
        // k是中序遍历中根结底的位置，使用map直接获取
        // k是相对位置，所有要减去il
        int k = map.get(pre[pl]) - il;

        // il + k是根节点的位置
        root.left = dfs(pre, in, pl + 1, pl + k, il, il + k - 1);
        root.right = dfs(pre, in, pl + k + 1, pr, il + k + 1, ir);

        return root;
    }
}