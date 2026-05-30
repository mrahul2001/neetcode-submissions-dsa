class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);

        return func(m, n, s, t, dp);
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
