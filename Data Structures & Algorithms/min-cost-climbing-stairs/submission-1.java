class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int step1 = dp[i - 1] + cost[i - 1];
            int step2 = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(step1, step2);
        }

        return dp[n];
    }

    private int func(int i, int[] cost, int[] dp) {
        if (i == 0 || i == 1)
            return 0;
        
        if (dp[i] != -1)
            return dp[i];

        int step1 = func(i - 1, cost, dp) + cost[i - 1];
        int step2 = func(i - 2, cost, dp) + cost[i - 2];

        return dp[i] = Math.min(step1, step2);
    }
}
