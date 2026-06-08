class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int prev = 0; prev < ind; prev++) {
                if (nums[ind] > nums[prev] && dp[prev] + 1 > dp[ind])
                    dp[ind] = dp[prev] + 1;
            }
            ans = Math.max(ans, dp[ind]);
        }

        return ans;
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
