class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev = -1; prev < ind; prev++) {

                int lis = dp[ind + 1][prev + 1];
                if (prev == -1 || nums[prev] < nums[ind]) {
                    lis = Math.max(lis, 1 + dp[ind + 1][ind + 1]);
                }

                dp[ind][prev + 1] = lis;
            }
        }

        return dp[0][0];
    }

    private int func(int prev, int ind, int[] nums, int[][] dp) {
        if (ind == nums.length)
            return 0;

        if (dp[ind][prev + 1] != -1)
            return dp[ind][prev + 1];

        int lis = func(prev, ind + 1, nums, dp);
        if (prev == -1 || nums[prev] < nums[ind]) {
            lis = Math.max(lis, 1 + func(ind, ind + 1, nums, dp));
        }

        return dp[ind][prev + 1] = lis;
    }
}
