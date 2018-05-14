package _37_Sudoku_Solver;

/**
 * Created by donglongcheng01 on 2018/5/14.
 */
public class Solution {

    /**
     * 6 / 6 test cases passed.
     *  Status: Accepted
     *  Runtime: 17 ms
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < 9; k++) {
                        board[i][j] = (char) ('1' + k);
                        if (isValid(board, i, j) && solve(board)) {
                            return true;
                        } else {
                            // backtracking to '.'
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == board[x][y] || board[x][i] == board[x][y]) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int pos_x = x - x % 3 + i;
                int pos_y = y - y % 3 + j;
                if (x != pos_x && y != pos_y && board[x][y] == board[pos_x][pos_y]) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {

    }
}
