class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0)
            return false;

        totalSum /= 2;

        boolean[][] dp = new boolean[n][totalSum + 1];
        for (boolean[] it : dp) it[0] = true;

        if (nums[0] <= totalSum)
            dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= totalSum; target++) {
                boolean take = false;
                if (nums[i] <= target)
                    take = dp[i - 1][target - nums[i]];
                boolean notTake = dp[i - 1][target];

                dp[i][target] = (take || notTake);
            }
        }

        return dp[n - 1][totalSum];
    }

    private boolean func(int i, int target, int[] nums, int[][] dp) {
        if (target == 0)
            return true;

        if (i == 0)
            return nums[0] == target;

        if (dp[i][target] != -1)
            return dp[i][target] == 1;

        boolean take = false;
        if (nums[i] <= target)
            take = func(i - 1, target - nums[i], nums, dp);
        boolean notTake = func(i - 1, target, nums, dp);

        dp[i][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }
}
