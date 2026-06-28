class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, - 1);

        return func(n, cost, dp);
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
