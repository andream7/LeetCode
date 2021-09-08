/**
螺旋矩阵
一种向右下左上四个方向搜索的模板题

 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length < 1) return result;

        int m = matrix.length, n = matrix[0].length;
        // 方向：右、下、左、上
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        // 标记已经使用过的点
        boolean[][] used = new boolean[m][n];

        // 当前遍历到点的x, y坐标
        // d的0到3分别表示右下左上四个方向
        int x = 0, y = 0, d = 0;
        for (int i = 0; i < m * n; i ++) {
            // 把当前遍历到的点加入结果集
            result.add(matrix[x][y]);
            used[x][y] = true;

            // 检验下一个位置是否合法
            // 不合法则更新方法，并重新计算下一个位置
            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= m || b < 0 || b >= n || used[a][b]) {
                d ++;
                d %= 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            // 更新下一个点的坐标
            x = a;
            y = b;
        }
        return result;
    }
}