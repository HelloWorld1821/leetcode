public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
                    for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        //如果下一状态是活的或者下一状态是从活变死的，则count+1
                        if (board[x][y] == 1 || board[x][y] == 2) {
                            count++;
                        }
                    }
                }
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
                else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        Solution s = new Solution();
        s.gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}