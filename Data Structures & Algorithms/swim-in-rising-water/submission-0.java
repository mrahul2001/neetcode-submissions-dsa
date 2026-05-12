class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;

        int[][] dir = {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int height = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == n - 1 && col == n - 1) {
                return height;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = row + dir[i][0];
                int nCol = col + dir[i][1];

                if ((nRow >= 0 && nRow < n) &&
                        (nCol >= 0 && nCol < n) &&
                        !visited[nRow][nCol]) {
                            
                    visited[nRow][nCol] = true;
                    q.add(new int[] {
                            Math.max(height, grid[nRow][nCol]),
                            nRow,
                            nCol
                    });
                }
            }
        }
        return n * n;
    }
}