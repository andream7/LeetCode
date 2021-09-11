/**
算法关键点：二分模板
返回一个数x平方根的整数部分，如果一个数的平方根刚好是整数，那么答案就是根号x，
但如果平方根是一个小数的话，返回下就是小于等于根号x的最大整数。
所以所求的是小于等于x的最大整数，套用模板二。
 */
class Solution {
public:
    int mySqrt(int x) {
       int l = 0, r = x;
       while (l < r) {
           int mid = l + (long long) r + 1 >> 1;
           if (mid <= x / mid) l = mid;
           else r = mid - 1; 
       } 
       return r;
    }
};