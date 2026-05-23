class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int up = grid[i][j], left = grid[i][j];

                if (i > 0)
                    up += dp[i - 1][j];
                else
                    up = (int) 1e9;

                if (j > 0)
                    left += dp[i][j - 1];
                else
                    left = (int) 1e9;

                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }

    private int func(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0)
            return (int) 1e9;

        if (i == 0 && j == 0)
            return grid[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = grid[i][j] + func(i - 1, j, grid, dp);
        int left = grid[i][j] + func(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }
}