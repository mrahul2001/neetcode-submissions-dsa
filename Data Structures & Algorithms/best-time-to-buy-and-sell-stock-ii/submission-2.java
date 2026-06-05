class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];
        for (int[] it : dp) Arrays.fill(it, 0);

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit;
                if (buy == 1) {
                    profit = Math.max(
                        dp[i + 1][0] + prices[i], dp[i + 1][1]);
                } else {
                    profit = Math.max(
                        dp[i + 1][1] - prices[i], dp[i + 1][0]);
                }

                dp[i][buy] = profit;
            }
        }

        return dp[0][0];
    }

    private int func(int i, int buy, int[] prices, int[][] dp) {
        if (i == prices.length)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        int profit;
        if (buy == 1) {
            profit = Math.max(func(i + 1, 0, prices, dp) + prices[i], func(i + 1, 1, prices, dp));
        } else {
            profit = Math.max(func(i + 1, 1, prices, dp) - prices[i], func(i + 1, 0, prices, dp));
        }

        return dp[i][buy] = profit;
    }
}