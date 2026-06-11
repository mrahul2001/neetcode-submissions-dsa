class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);

       return (func(0, 0, 0, s1, s2, s3, dp) == 1) ? true : false; 
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
