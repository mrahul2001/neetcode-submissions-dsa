class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647;

        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    q.add(new int[]{i, j});
            }
        }

        int[][] nextValues = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = row + nextValues[i][0];
                int nextCol = col + nextValues[i][1];

                if ((nextRow >= 0 && nextRow < m) &&
                (nextCol >= 0 && nextCol < n) &&
                grid[nextRow][nextCol] == INF) {
                    grid[nextRow][nextCol] = grid[row][col] + 1;
                    q.add(new int[]{nextRow, nextCol});
                }
            }

        }
    }
}
