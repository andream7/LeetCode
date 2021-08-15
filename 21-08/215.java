/**
1. 快排后，返回第k个元素
2. 优先队列：小顶堆，堆顶元素是当前堆中的最小元素。
    假设nums长度为n，我们就弹出n - k个元素，剩下的堆顶就是第k大的元素
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(item);
        for (int item: nums) {
            // 维护一个大小为k的堆
            if (pq.size() > k) {
                // 取得堆顶元素并且从当前堆中删除
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/**
快排的做法
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 快排后序列由小到大，第k大相当于第n-k个
        k = nums.length - k;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j == k) {
                break;
            } else if (j < k) {
                low = j + 1;
            } else {
                high = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int low, int high) {
        int i = low, j = high + 1;
        while (true) {
            while (a[++i] < a[low] && i < high);
            while (a[--j] > a[low] && j > low);
            if (i >=j ) break;
            swap(a, i, j);
        }
        swap(a, low, j);
        // j是已经确定好的位置
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}