/**
寻找峰值：二分模板，两个都可以套
 */

// 版本一
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}

// 版本二
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid  = l + r + 1>> 1;
            if(nums[mid] > nums[mid - 1]) l = mid;
            else r = mid - 1;
        }
        return r;
    }
}