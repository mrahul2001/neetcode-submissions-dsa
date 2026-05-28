class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[] prev = new int[len2 + 1];

        for (int j = 0; j <= len2; j++)
            prev[j] = 0;

        for (int i = 1; i <= len1; i++) {
            int[] temp = new int[len2 + 1];
            temp[0] = 0;
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    temp[j] = 1 + prev[j - 1];
                else
                    temp[j] = Math.max(prev[j], temp[j - 1]);
            }
            prev = temp;
        }

        return prev[len2];
    }

    private int func(int i, int j, String text1, String text2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j))
            dp[i][j] = 1 + func(i - 1, j - 1, text1, text2, dp);
        else
            dp[i][j] = Math.max(func(i - 1, j, text1, text2, dp), func(i, j - 1, text1, text2, dp));

        return dp[i][j];
    }
}