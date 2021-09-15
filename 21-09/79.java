/**
算法关键点：dfs
先枚举单词的起点，然后依次枚举单词的每个字母。
使用过的字母需要改成一个特殊字符，避免重复使用。
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j)) 
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int u, int x, int y) {
        // 当前格子不等于要搜索的字母，直接返回
        if (board[x][y] != word.charAt(u)) return false;

        // 已经匹配的长度等于单词长度，说明搜索完成
        if (u == word.length() - 1) return true;

        // 用数组定义搜索方向：上右下左
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        char t = board[x][y];
        board[x][y] = '*';

        for (int i = 0; i < 4; i ++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < board.length && b >= 0 && b < board[a].length) {
                if (dfs(board, word, u + 1, a, b)) {
                    return true;
                }
            }
        }
        // 还原现场
        board[x][y] = t;
        return false;
    }
}