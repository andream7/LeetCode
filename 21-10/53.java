class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], pre = 0;
        for (int num: nums) {
            // 如果pre+num比num还小，就从num重新开始
            pre = Math.max(pre + num, num);
            // res记录的是最大值
            res = Math.max(pre, res);
        }
        return res;
    }
}