class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;

        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }

    private int func(int i, int j, String word1, String word2, int[][] dp) {
        if (i == 0)
            return j;

        if (j == 0)
            return i;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            dp[i][j] = func(i - 1, j - 1, word1, word2, dp);
        } else {
            dp[i][j] = 1
                + Math.min(func(i - 1, j - 1, word1, word2, dp),
                    Math.min(func(i - 1, j, word1, word2, dp), func(i, j - 1, word1, word2, dp)));
        }

        return dp[i][j];
    }
}
