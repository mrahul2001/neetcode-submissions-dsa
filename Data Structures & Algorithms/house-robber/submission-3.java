class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int prev0 = nums[0];
        int prevNeg = 0;

        for (int i = 1; i < n; i++) {
            int take = nums[i] + prevNeg;
            int notTake = prev0;

            int curr = Math.max(take, notTake);
            prevNeg = prev0;
            prev0 = curr;
        }

        return prev0;
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
