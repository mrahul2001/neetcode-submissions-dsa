class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0, time = 0;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[] nextRow = {1, 0, -1, 0};
        int[] nextCol = {0, 1, 0, -1};

        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int it = 0; it < size; it++) {
                Pair<Integer, Integer> curr = q.poll();
                int currRow = curr.getKey();
                int currCol = curr.getValue();

                for (int i = 0; i < 4; i++) {
                    int newRow = currRow + nextRow[i];
                    int newCol = currCol + nextCol[i];

                    if ((newRow >= 0 && newRow < rows) &&
                    (newCol >= 0 && newCol < cols) &&
                    grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        fresh--;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
