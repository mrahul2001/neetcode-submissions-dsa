class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] front1 = new int[2];
        int[] front2 = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[2];
            for (int buy = 0; buy < 2; buy++) {
                int profit;
                if (buy == 1) {
                    profit = Math.max(front1[0] - prices[i], front1[1]);
                } else {
                    profit = Math.max(front2[1] + prices[i], front1[0]);
                }

                curr[buy] = profit;
            }
            front2 = front1;
            front1 = curr;
        }

        return front1[1];
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
