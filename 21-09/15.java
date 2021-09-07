/**
用双指针代替三重循环中的两重循环
注意：sum=0时，左右指针移动要避开重复元素
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 如果当前值大于0，跳出循环
            if (nums[i] > 0 ) break;
            // 如果与上一轮循环的数重复，跳过本轮循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left+1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right-1] == nums[right]) {
                        right--;
                    }
                    left ++;
                    right --;
                } else if (sum > 0) right--;
                else left++;
            }
        }
        return res;
    }
}