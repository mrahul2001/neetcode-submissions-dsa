class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    return dfs(i, j, visited, grid, rows, cols);
            }
        }

        return 0;
    }

    private int dfs(int i, int j, boolean[][] visited, int[][] grid, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0)
            return 1;
        
        if (visited[i][j])
            return 0;
        
        visited[i][j] = true;
        
        return dfs(i + 1, j, visited, grid, rows, cols) +
            dfs(i - 1, j, visited, grid, rows, cols) +
            dfs(i, j + 1, visited, grid, rows, cols) +
            dfs(i, j - 1, visited, grid, rows, cols);
    }
}