class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);

        int ans = func(n - 1, coins, amount, dp);
        
        if (ans >= 1e9)
            return -1;
        return ans;
    }

    private int func(int i, int[] coins, int amt, int[][] dp) {
        if (i == 0) {
            if (amt % coins[i] == 0)
                return amt / coins[i];
            
            return (int) 1e9;
        }

        if (dp[i][amt] != -1)
            return dp[i][amt];

        int take = (int) 1e9;
        if (amt >= coins[i]) {
            take = 1 + func(i, coins, amt - coins[i], dp);
        }
        int notTake = func(i - 1, coins, amt, dp);

        return dp[i][amt] = Math.min(take, notTake);
    }
}
