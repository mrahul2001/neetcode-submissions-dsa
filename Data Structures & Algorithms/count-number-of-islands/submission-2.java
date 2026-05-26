class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(i, j, m, n, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, int m, int n, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1' || visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;

        bfs(i + 1, j, m, n, grid, visited);
        bfs(i - 1, j, m, n, grid, visited);
        bfs(i, j + 1, m, n, grid, visited);
        bfs(i, j - 1, m, n, grid, visited);
    }
}
