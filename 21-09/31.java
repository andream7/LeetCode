/* 
1. 下一个数比当前数大，只需将后面的“大数”与前面是“小数”交换，就能得到一个更大的数。
2. 下一个数增加的幅度尽可能小，才能满足“下一个排列”的要求。
    为了满足这个要求，我们需要：
    1. 在尽可能右的低位进行交换，需要从后往前查找。
    2. 将一个尽可能小的“大数”于前面的“小数”交换
    3. 将“大数”换到前面后，需要将“大数”后面的所有数重置为升序，升序排列就是最小的排列。

算法过程：
1. 从后向前查找第一个相邻升序的元素对(i,j)，满足A[i] < A[j]。此时[J,end)必是降序
2. 在[J,end)从后向前查找第一个满足A[k] > A[i] 的 k。A[i]、A[k]分别是上文所说的小数，大数。
3. 将A[i]与A[k]交换。
4. 可以断定这时[j, end)必是降序，逆置[j,end)，使其升序
5. 如果在步骤一找不到符合的元素对，说明当前的[begin,end)为一个降序序列，直接跳到步骤四
**/
class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length - 1;
        // 从后向前查找第一个相邻升序的元素对(i,j)
        while (j > 0 && nums[j - 1] >= nums[j]) {
            j --;
        }
        // 如果不是全降序
        if (j > 0) {
            int k = nums.length - 1;
            // 在[J,end)从后向前查找第一个满足A[k] > A[i] 的 k
            while (nums[k] <= nums[j - 1]) {
                k --;
            }
            // 将A[i]与A[k]交换
            swap(nums, k , j - 1);
        }
        // 这时[j, end)必是降序，逆置[j,end)，使其升序
        reverse(nums, j, nums.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    } 
}

