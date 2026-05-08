class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        boolean found = false;

        // find first island
        for (int i = 0; i < rows; i++) {
            if (found)
                break;

            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, q, rows, cols);
                    found = true;
                    break;
                }
            }
        }

        int steps = 0;

        // multi-source BFS
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols) {
                        // reached second island
                        if (grid[nr][nc] == 1) {
                            return steps;
                        }

                        // expand water
                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            q.offer(new int[] {nr, nc});
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private void dfs(int r, int c, int[][] grid, Queue<int[]> q, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = 2;
        q.offer(new int[] {r, c});

        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], grid, q, rows, cols);
        }
    }
}