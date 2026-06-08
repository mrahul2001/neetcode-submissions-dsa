class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);

        return func(-1, 0, nums, dp);
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
