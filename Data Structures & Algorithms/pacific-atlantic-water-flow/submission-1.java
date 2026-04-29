class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, cols - 1, atlantic, heights);
        }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, pacific, heights);
            dfs(rows - 1, j, atlantic, heights);
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

    private void dfs(int i, int j, boolean[][] ocean, int[][] heights) {
        ocean[i][j] = true;

        int[][] nextValues = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int it = 0; it < 4; it++) {
            int nextRow = i + nextValues[it][0];
            int nextCol = j + nextValues[it][1];

            if ((nextRow >= 0 && nextRow < heights.length) &&
            (nextCol >= 0 && nextCol < heights[0].length) &&
            !ocean[nextRow][nextCol] && heights[nextRow][nextCol] >= heights[i][j])
                dfs(nextRow, nextCol, ocean, heights);
        }
    }
}
