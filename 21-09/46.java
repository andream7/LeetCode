/**
从前往后。一位一位枚举，每次选择一个没有被使用过的数。
选好这个数之后，将该数的状态改成“已被使用”，同时将该数记录在相应位置上，然后递归。
递归返回时，不要忘记将该数状态改成“未被使用”。并将该数从相应位置上删除。
 */
 class Solution {

    List<List<Integer>> res = new ArrayList();
    Stack<Integer> path = new Stack();

    public List<List<Integer>> permute(int[] c) {
        boolean[] used = new boolean[c.length];
        dfs(c, used);
        return res;
    }

    public void dfs(int[] c, boolean[] used){
        if(c.length == path.size()){
            res.add(new ArrayList(path));
            return;
        }

        // 遍历每一个位置
        // 排列问题, 每一个位置可以放数组中的任意一个数, 
        // 所以指针i总是从0开始, 此时就需要加上状态数组辅助记录
        for(int i = 0; i < c.length; i++){
            if(!used[i]){
                path.push(c[i]);
                used[i] = true;
                dfs(c, used);
                used[i] = false;
                path.pop();
            }
        }
    }
}