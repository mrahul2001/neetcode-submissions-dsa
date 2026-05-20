class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        int neg = 0;

        for (int i = 1; i < n; i++) {
            int take;
            if (i > 1)
                take = nums[i] + dp[i - 2];
            else
                take = nums[i] + neg;
            int notTake = dp[i - 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[n - 1];
    }

    private int func(int i, int[] nums, int[] dp) {
        if (i < 0)
            return 0;

        if (i == 0)
            return nums[0];

        if (dp[i] != -1)
            return dp[i];

        int take = nums[i] + func(i - 2, nums, dp);
        int notTake = func(i - 1, nums, dp);

        return dp[i] = Math.max(take, notTake);
    }
}
