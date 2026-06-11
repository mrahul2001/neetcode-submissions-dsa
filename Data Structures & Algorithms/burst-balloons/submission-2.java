class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++) arr[i + 1] = nums[i];

        arr[0] = 1;
        arr[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int maxi = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int coins = arr[i - 1] * arr[ind] * arr[j + 1] + 
                    dp[i][ind - 1] + dp[ind + 1][j];

                    maxi = Math.max(maxi, coins);
                }

                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }

    private int func(int i, int j, int[] arr, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int coins = arr[i - 1] * arr[ind] * arr[j + 1] + func(i, ind - 1, arr, dp)
                + func(ind + 1, j, arr, dp);

            maxi = Math.max(maxi, coins);
        }

        return dp[i][j] = maxi;
    }
}
