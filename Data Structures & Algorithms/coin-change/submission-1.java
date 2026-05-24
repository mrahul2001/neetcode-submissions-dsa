class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = func(n - 1, coins, amount);
        if (ans >= 1e9)
            return -1;
        return ans;
    }

    private int func(int i, int[] coins, int amt) {
        if (i == 0) {
            if (amt % coins[0] == 0)
                return amt/coins[0];

            return (int) 1e9;
        }

        int take = (int) 1e9;
        if (coins[i] <= amt) {
            take = 1 + func(i, coins, amt - coins[i]);
        }
        int notTake = func(i - 1, coins, amt);

        return Math.min(take, notTake);
    }
}
