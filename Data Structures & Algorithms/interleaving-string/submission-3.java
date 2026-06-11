class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        int m = s1.length();
        int n = s2.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n)
                    continue;

                int k = i + j;

                boolean ans = false;

                if (i < m && s1.charAt(i) == s3.charAt(k)) {
                    ans |= dp[i + 1][j];
                }

                if (j < n && s2.charAt(j) == s3.charAt(k)) {
                    ans |= dp[i][j + 1];
                }

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }

    private int func(int i, int j, int k, String s1, String s2, String s3, int[][] dp) {
        if (i == s1.length() && j == s2.length() && k == s3.length())
            return dp[i][j] = 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (func(i + 1, j, k + 1, s1, s2, s3, dp) == 1)
                return dp[i][j] = 1;
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (func(i, j + 1, k + 1, s1, s2, s3, dp) == 1)
                return dp[i][j] = 1;
        }

        return dp[i][j] = 0;
    }
}
