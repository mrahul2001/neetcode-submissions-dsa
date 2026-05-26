class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                else if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }

        int[][] nextValues = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        int time = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int it = 0; it < size; it++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for (int i = 0; i < 4; i++) {
                    int nextRow = row + nextValues[i][0];
                    int nextCol = col + nextValues[i][1];

                    if ((nextRow >= 0 && nextRow < rows) &&
                    (nextCol >= 0 && nextCol < cols) &&
                    grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        q.add(new int[]{nextRow, nextCol});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
