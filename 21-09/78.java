/**
算法关键点：dfs

枚举每个位置的数 选 还是 不选，并递归到下一层，
当u == nums.length时，表示有一种满足题意的情况看，加入到ans链表中
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> path = new Stack<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.clear();
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int u){
        if(u == nums.length){
            res.add(new ArrayList(path));
            return;
        }

        // 选
        path.add(nums[u]);
        dfs(nums, u + 1);
        path.pop();

        // 不选
        dfs(nums, u + 1);
    }
}