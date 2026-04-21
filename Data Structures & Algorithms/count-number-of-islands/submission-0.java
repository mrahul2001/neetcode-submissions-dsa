class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1'){
                    bfs(i, j, rows, cols, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, int rows, int cols, char[][] grid, boolean[][] visited) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;

        int[] nextRow = {1, 0, -1, 0};
        int[] nextCol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair<Integer, Integer> curr = q.poll();
            int currRow = curr.getKey();
            int currCol = curr.getValue();

            for (int it = 0; it < 4; it++) {
                int row = currRow + nextRow[it];
                int col = currCol + nextCol[it];

                if ((row >= 0 && row < rows) &&
                    (col >= 0 && col < cols) &&
                    grid[row][col] == '1' &&
                    !visited[row][col]) {
                    visited[row][col] = true;
                    q.add(new Pair(row, col));
                }
            }
        }
    }
}
