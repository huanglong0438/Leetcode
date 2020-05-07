package _79_word_search;

/**
 * Solution
 *
 * @title Solution
 * @Description
 * @Author donglongcheng01
 * @Date 2020-05-07
 **/
class Solution {

    private char[][] board;

    private int m,n;

    private boolean[][] marked;

    private int[][] directions = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};

    private String word;

    public boolean exist(char[][] board, String word) {
        init(board, word);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void init(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
    }

    private boolean dfs(int i, int j, int cur) {
        if(cur == word.length() - 1) {
            return board[i][j] == word.charAt(cur);
        }
        if(board[i][j] != word.charAt(cur)) {
            return false;
        }
        for(int d = 0; d < 4; d++) {
            marked[i][j] = true;
            int newI = i + directions[d][0];
            int newJ = j + directions[d][1];
            if(notOutOfBound(newI, newJ)
                    && !marked[newI][newJ]
                    && dfs(newI, newJ, cur+1)) {
                return true;
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean notOutOfBound(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
