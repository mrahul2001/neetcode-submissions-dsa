class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[] prev = new int[n + 1];

        for (int j = 0; j <= n; j++) 
            prev[j] = 0;

        prev[0] = 1;

        for (int i = 1; i <= m; i++) {
            int[] temp = new int[n + 1];
            temp[0] = 1;
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    temp[j] = prev[j - 1] + prev[j];
                } else {
                    temp[j] = prev[j];
                }
            }
            prev = temp;
        }

        return prev[n];
    }

    private int func(int i, int j, String s, String t, int[][] dp) {
        if (j == 0)
            return 1;

        if (i == 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = func(i - 1, j - 1, s, t, dp) + func(i - 1, j, s, t, dp);
        } else {
            dp[i][j] = func(i - 1, j, s, t, dp);
        }

        return dp[i][j];
    }
}
