class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0)
            return false;
        
        totalSum /= 2;
        
        int[][] dp = new int[n][totalSum + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);

        return func(n - 1, totalSum, nums, dp);
    }

    private boolean func(int i, int target, int[] nums, int[][] dp) {
        if (target == 0)
            return true;
        
        if (i == 0)
            return nums[0] == target;

        if (dp[i][target] != -1)
            return dp[i][target] == 1 ? true : false;
        
        boolean take = false;
        if (nums[i] <= target)
            take = func(i - 1, target - nums[i], nums, dp);
        boolean notTake = func(i - 1, target, nums, dp);
        
        dp[i][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }
}
