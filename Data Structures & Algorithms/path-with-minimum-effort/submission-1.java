class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];
        for (int[] it : effort)
            Arrays.fill(it, (int) 1e9);
        
        effort[0][0] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{0, 0, 0});

        int[][] nxtValues = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int effortTaken = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == m - 1 && col == n - 1)
                return effortTaken;
            
            for (int i = 0; i < 4; i++) {
                int nextRow = row + nxtValues[i][0];
                int nextCol = col + nxtValues[i][1];

                if ((nextRow >= 0 && nextRow < m) &&
                (nextCol >= 0 && nextCol < n)) {
                    int newEffort = Math.max(effortTaken, Math.abs(heights[row][col] - heights[nextRow][nextCol]));

                    if (newEffort < effort[nextRow][nextCol]) {
                        effort[nextRow][nextCol] = newEffort;
                        q.add(new int[]{newEffort, nextRow, nextCol});
                    }
                }
            }
        }

        return 0; 
    }
}