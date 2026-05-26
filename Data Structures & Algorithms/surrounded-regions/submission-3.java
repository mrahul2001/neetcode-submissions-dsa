class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1)
                        && board[i][j] == 'O') {

                    q.add(new int[]{i, j});
                    board[i][j] = '#';
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    board[nr][nc] == 'O') {

                    board[nr][nc] = '#';
                    q.add(new int[]{nr, nc});
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O'; 
                }
            }
        }
    }
}