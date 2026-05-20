class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = 2; i <= cost.length; i++) {

            int oneStep = prev1 + cost[i - 1];
            int twoStep = prev2 + cost[i - 2];

            int curr = Math.min(oneStep, twoStep);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
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
