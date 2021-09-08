/**
关键词：连通块个数、四个方向dfs
遍历整个矩阵，当遇到grid[i][j] == '1'时，从此点开始做深度优先搜索dfs，
同时把计数岛屿的变量count加一，在深度有限搜索中把该岛包含的坐标全部标记为已搜索。

 */
class Solution {
    // 四个方法，左上右下
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';

        // 遍历四个方向
        for (int i = 0; i < 4; i ++) {
            // (a, b) 是下一个要搜索的坐标
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && grid[a][b] == '1') {
                dfs(grid, a, b);
            }
        }

    }
}