/**
二分查找模板题
 */
class Solution {
    public int search(int[] nums, int target) {
        // 边界情况
        if (nums.length == 0) return -1;
        // 二分查找找到最小值
        int len = nums.length - 1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            // 说明小的部分多，r应该左移
            if (nums[mid] <= nums[len]) r = mid;
            else l = mid + 1;
        }
        // l==r的位置就是最小值所在的位置
        // 判断目标值在哪个区间
        if (target <= nums[len]) {
            r = len;
        } else {
           l = 0;
           r --; 
        } 

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        
        if (nums[l] == target) return l;
        else return -1;
    }
}