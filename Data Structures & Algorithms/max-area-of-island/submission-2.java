class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(i, j, rows, cols, grid, visited));
                }
            }
        }

        return maxArea;
    }

    private int bfs(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        int[][] nextValues = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        int area = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int it = 0; it < 4; it++) {
                int nextRow = row + nextValues[it][0];
                int nextCol = col + nextValues[it][1];

                if ((nextRow >= 0 && nextRow < rows) &&
                (nextCol >= 0 && nextCol < cols) &&
                !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1) {
                    visited[nextRow][nextCol] = true;
                    q.add(new int[]{nextRow, nextCol});
                    area++;
                }
            }
        }
        return area;
    }
}
