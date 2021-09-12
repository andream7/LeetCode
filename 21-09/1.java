/**
算法关键：hash表存储当前数及其下标
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key代表数字，value代表出现的下标
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            int other = target - nums[i];
            // 如果map中存在另外一个数
            if (map.containsKey(other)) {
                // 返回值是两个数的下标
                return new int[] {map.get(other), i};
            }
            // 把当前遍历到的值及其下标存入map
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}