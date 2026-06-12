class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] nextValues = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        int[][] indegree = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int it = 0; it < 4; it++) {
                    int nextRow = i + nextValues[it][0];
                    int nextCol = j + nextValues[it][1];

                    if ((nextRow >= 0 && nextRow < rows) &&
                    (nextCol >= 0 && nextCol < cols) &&
                    matrix[nextRow][nextCol] < matrix[i][j]) {
                        indegree[i][j]++;
                    }
                } 
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (indegree[i][j] == 0)
                    q.add(new int[]{i, j});
            }
        }

        int res = 0;
        while (!q.isEmpty()) {
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
                    matrix[nextRow][nextCol] > matrix[row][col]) {
                        indegree[nextRow][nextCol]--;

                        if (indegree[nextRow][nextCol] == 0)
                            q.add(new int[]{nextRow, nextCol});
                    }
                }
            }
            res++; 
        }

        return res;
    }
}
