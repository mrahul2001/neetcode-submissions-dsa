class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int step1 = dp[i - 1];
            int step2 = dp[i - 2];

            dp[i] = step1 + step2;
        }

        return dp[n];
    }

    private int func(int i, int[] dp) {
        if (i == 0 || i == 1)
            return 1;

        if (dp[i] != -1)
            return dp[i];

        int step1 = func(i - 1, dp);
        int step2 = func(i - 2, dp);

        return dp[i] = step1 + step2;
    }
}
