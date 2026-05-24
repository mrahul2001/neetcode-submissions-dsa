class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] prev = new int[amount + 1];
        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                prev[amt] = amt / coins[0];
            else
                prev[amt] = (int) 1e9;
        }

        for (int i = 1; i < n; i++) {
            int[] temp = new int[amount + 1];
            for (int amt = 0; amt <= amount; amt++) {
                int take = (int) 1e9;
                if (coins[i] <= amt) {
                    take = 1 + temp[amt - coins[i]];
                }
                int notTake = prev[amt];

                temp[amt] = Math.min(take, notTake);
            }
            prev = temp;
        }

        int ans = prev[amount];
        if (ans >= 1e9)
            return -1;
        return ans;
    }

    private int func(int i, int[] coins, int amt, int[][] dp) {
        if (i == 0) {
            if (amt % coins[0] == 0)
                return amt / coins[0];

            return (int) 1e9;
        }

        if (dp[i][amt] != -1)
            return dp[i][amt];

        int take = (int) 1e9;
        if (coins[i] <= amt) {
            take = 1 + func(i, coins, amt - coins[i], dp);
        }
        int notTake = func(i - 1, coins, amt, dp);

        return dp[i][amt] = Math.min(take, notTake);
    }
}
