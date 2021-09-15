/**
算法思路：操作分解
直接旋转90°比较困难，我们把它分解成两个操作:
1. 先以左上-右下对角线为轴做翻转；
2. 再以中心轴线为轴翻转。
 */

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int l = 0, r = m - 1; l < r; l ++, r --) {
                swap(matrix, i, l, i, r);
            }
        }
    }
    private void swap(int[][] matrix , int x1, int y1, int x2, int y2){
        int t = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = t;
    }
}