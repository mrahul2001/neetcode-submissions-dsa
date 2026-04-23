class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                dfs(i, 0, rows, cols, pacific, heights);
                dfs(i, cols - 1, rows, cols, atlantic, heights);
            }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, rows, cols, pacific, heights);
            dfs(rows - 1, j, rows, cols, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }

    private void dfs(int i, int j, int rows, int cols, boolean[][] ocean, int[][] heights) {
        ocean[i][j] = true;

        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int newRow = i + dRow[k];
            int newCol = j + dCol[k];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                && !ocean[newRow][newCol] && heights[newRow][newCol] >= heights[i][j]) {
                dfs(newRow, newCol, rows, cols, ocean, heights);
            }
        }
    }
}
