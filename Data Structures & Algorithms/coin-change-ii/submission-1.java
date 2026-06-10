class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);

        return func(n - 1, amount, coins, dp);
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
