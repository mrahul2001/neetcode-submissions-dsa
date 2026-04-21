class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1'){
                    dfs(i, j, rows, cols, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int rows, int cols, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != '1' || visited[i][j] == true)
            return;
        
        visited[i][j] = true;

        dfs(i + 1, j, rows, cols, grid, visited);
        dfs(i - 1, j, rows, cols, grid, visited);
        dfs(i, j + 1, rows, cols, grid, visited);
        dfs(i, j - 1, rows, cols, grid, visited);
    }
}
