class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        if (n > 0) dp[1] = 1;
        if (n > 1) dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            int step1 = dp[i - 1];
            int step2 = dp[i - 2];
            int step3 = dp[i - 3];

            dp[i] = step1 + step2 + step3;
        }

        return dp[n];
    }

    private int func(int i, int[] dp) {
        if (i == 0 || i == 1 || i == 2)
            return i == 0 ? 0 : 1;

        if (dp[i] != -1)
            return dp[i];

        int step1 = func(i - 1, dp);
        int step2 = func(i - 2, dp);
        int step3 = func(i - 3, dp);

        return dp[i] = step1 + step2 + step3;
    }
}