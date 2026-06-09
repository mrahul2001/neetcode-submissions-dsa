class Solution {
    public int lastStoneWeightII(int[] nums) {
        int n = nums.length;
        
        int totalSum = Arrays.stream(nums).sum();
        int target = (totalSum + 1) / 2;

        int[][] dp = new int[n][target + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);

        return func(n - 1, 0, totalSum, target, nums, dp);
    }

    private int func(int i, int total, int totalSum, int target, int[] nums, int[][] dp) {
        if (i < 0 || total >= target) {
            return Math.abs(total - (totalSum - total));
        }

        if (dp[i][total] != -1)
            return dp[i][total];

        int take = func(i - 1, total + nums[i], totalSum, target, nums, dp);
        int notTake = func(i - 1, total, totalSum, target, nums, dp);

        return dp[i][total] = Math.min(take, notTake);
    }
}