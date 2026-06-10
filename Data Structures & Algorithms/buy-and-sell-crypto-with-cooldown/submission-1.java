class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];
        for (int[] it : dp)
            Arrays.fill(it, -1);

        return func(0, 1, prices, dp);
    }

    private int func(int i, int buy, int[] prices, int[][] dp) {
        if (i >= prices.length)
            return 0;
        
        if (dp[i][buy] != -1)
            return dp[i][buy];
        
        int profit;
        if (buy == 1) {
            profit = Math.max(func(i + 1, 0, prices, dp) - prices[i], func(i + 1, 1, prices, dp));
        } else {
            profit = Math.max(func(i + 2, 1, prices, dp) + prices[i], func(i + 1, 0, prices, dp));
        }

        return dp[i][buy] = profit;
    }
}
