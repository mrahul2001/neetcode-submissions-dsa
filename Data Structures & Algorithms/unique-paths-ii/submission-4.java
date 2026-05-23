class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1)
            return 0;

        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[0] = 1;
                    continue;
                }

                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                    continue;
                }

                int up = 0, left = 0;
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                temp[j] = up + left;
            }
            prev = temp;
        }

        return prev[n - 1];
    }

    private int func(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1)
            return 0;

        if (i == 0 && j == 0)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = func(i - 1, j, obstacleGrid, dp);
        int left = func(i, j - 1, obstacleGrid, dp);

        return dp[i][j] = up + left;
    }
}