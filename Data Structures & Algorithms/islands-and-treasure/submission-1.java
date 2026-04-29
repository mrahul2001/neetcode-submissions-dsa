class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int[][] nextValues = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {
            Pair<Integer, Integer> currNode = q.poll();
            int currRow = currNode.getKey();
            int currCol = currNode.getValue();

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + nextValues[i][0];
                int nextCol = currCol + nextValues[i][1];

                if ((nextRow >= 0 && nextRow < rows) &&
                (nextCol >= 0 && nextCol < cols) &&
                grid[nextRow][nextCol] == INF) {
                    grid[nextRow][nextCol] = grid[currRow][currCol] + 1;
                    q.add(new Pair(nextRow, nextCol));
                }
            }
        }
    }
}
