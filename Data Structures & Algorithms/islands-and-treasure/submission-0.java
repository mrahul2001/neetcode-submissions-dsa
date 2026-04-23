class Solution {
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
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

        int[] nextRow = {1, 0, -1, 0};
        int[] nextCol = {0, 1, 0, -1};
    
        while(!q.isEmpty()) {
            Pair<Integer, Integer> curr = q.poll();
            int currRow = curr.getKey();
            int currCol = curr.getValue();

            for (int i = 0; i < 4; i++) {
                int newRow = currRow + nextRow[i];
                int newCol = currCol + nextCol[i];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    grid[newRow][newCol] == INF) {

                    grid[newRow][newCol] = grid[currRow][currCol] + 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
