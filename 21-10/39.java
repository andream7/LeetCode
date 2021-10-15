class Solution {
    List<List<Integer>> res = new ArrayList<>();
    // 存储一次搜索的结果
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] can, int target) {
        Arrays.sort(can);
        // 从下标为0的数开始搜索
        helper(can, 0, target);
        return res;
    }
    public void helper(int[] can, int start, int target) {
        // target减小到0， 说明找到一个结果
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < can.length; i++) {
            // 比剩余的target大，直接跳出
            if (can[i] > target) break;
            // 加入到list
            list.add(can[i]);
            // 进行下一轮遍历
            helper(can, i, target - can[i]);
            // 移除最后一个，恢复现场
            list.remove(list.size() - 1);
        }
    }
}