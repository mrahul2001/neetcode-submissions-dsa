class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, rows, cols, board);
            dfs(i, cols - 1, rows, cols, board);
        }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, rows, cols, board);
            dfs(rows - 1, j, rows, cols, board);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, int rows, int cols, char[][] board) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != 'O')
            return;
        
        board[i][j] = '#';

        dfs(i + 1, j, rows, cols, board);
        dfs(i, j + 1, rows, cols, board);
        dfs(i - 1, j, rows, cols, board);
        dfs(i, j - 1, rows, cols, board);
    }
}
