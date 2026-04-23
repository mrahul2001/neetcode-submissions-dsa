class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1)
                    maxArea = Math.max(dfs(i, j, rows, cols, visited, grid), maxArea);
            }
        }

        return maxArea;
    }

    private int dfs(int i, int j, int rows, int cols, boolean[][] visited, int[][] grid) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != 1 || visited[i][j])
            return 0;
        
        visited[i][j] = true;
        int count = 1;
        count += dfs(i + 1, j, rows, cols, visited, grid);
        count += dfs(i, j + 1, rows, cols, visited, grid);
        count += dfs(i - 1, j, rows, cols, visited, grid);
        count += dfs(i, j - 1, rows, cols, visited, grid);

        return count;
    }
}
