public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowcheck = new int[9][9];
        int[][] colcheck = new int[9][9];
        int[][] boxcheck = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !isValid(board[i][j], i, j, rowcheck, colcheck, boxcheck)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char c, int row, int col, int[][] rowcheck, int[][] colcheck, int[][] boxcheck) {
        int boxrow = row / 3 * 3;
        int boxcol = col / 3 * 3;
        if (rowcheck[row][c - '1'] == 1 || colcheck[col][c - '1'] == 1 || boxcheck[boxrow + boxcol / 3][c - '1'] == 1) {
            return false;
        }
        rowcheck[row][c - '1'] = 1;
        colcheck[col][c - '1'] = 1;
        boxcheck[boxrow + boxcol / 3][c - '1'] = 1;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        if (s.isValidSudoku(board)) {
            System.out.println("Valid Sudoku");
        }
        else {
            System.out.println("Invalid Sudoku");
        }
    }
}
