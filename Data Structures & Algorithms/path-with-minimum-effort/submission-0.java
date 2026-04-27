class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] distances = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        distances[0][0] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{0, 0, 0});

        int[][] nextValues = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int effort = curr[0];
            int currRow = curr[1];
            int currCol = curr[2];

            if (currRow == rows - 1 && currCol == cols - 1)
                return effort;
            
            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + nextValues[i][0];
                int nextCol = currCol + nextValues[i][1];

                if ((nextRow >= 0 && nextRow < rows) &&
                    (nextCol >= 0 && nextCol < cols)) {
                    int newEffort = Math.max(Math.abs(heights[nextRow][nextCol] - heights[currRow][currCol]), effort);

                    if (newEffort < distances[nextRow][nextCol]) {
                        distances[nextRow][nextCol] = newEffort;
                        q.add(new int[]{newEffort, nextRow, nextCol});    
                    }
                }
            }
        }
        return 0;
    }
}