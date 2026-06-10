class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                dp[0][amt] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int amt = 0; amt <= amount; amt++) {
                int take = 0;
                if (coins[i] <= amt) {
                    take = dp[i][amt - coins[i]];
                }
                int notTake = dp[i - 1][amt];

                dp[i][amt] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }

    private int func(int i, int amt, int[] coins, int[][] dp) {
        if (i == 0) {
            if (amt % coins[0] == 0)
                return 1;
            return 0;
        }

        if (dp[i][amt] != -1)
            return dp[i][amt];

        int take = 0;
        if (coins[i] <= amt) {
            take = func(i, amt - coins[i], coins, dp);
        }
        int notTake = func(i - 1, amt, coins, dp);

        return dp[i][amt] = take + notTake;
    }
}
