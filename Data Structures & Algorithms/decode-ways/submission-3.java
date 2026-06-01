class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int ways = 0;

            // take current digit alone
            if (s.charAt(i - 1) != '0') {
                ways += dp[i - 1];
            }

            // take last two digits together
            int num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');

            if (num >= 10 && num <= 26) {
                ways += dp[i - 2];
            }

            dp[i] = ways;
        }

        return dp[n];
    }

    private int func(int i, String s, int[] dp) {
        if (i == 0)
            return 1;

        if (i == 1)
            return s.charAt(i - 1) == '0' ? 0 : 1;

        if (dp[i] != -1)
            return dp[i];

        int ways = 0;

        // take current digit alone
        if (s.charAt(i - 1) != '0') {
            ways += func(i - 1, s, dp);
        }

        // take last two digits together
        int num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');

        if (num >= 10 && num <= 26) {
            ways += func(i - 2, s, dp);
        }

        return dp[i] = ways;
    }
}