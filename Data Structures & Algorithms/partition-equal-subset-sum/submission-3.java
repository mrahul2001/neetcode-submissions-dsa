class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0)
            return false;

        totalSum /= 2;

        boolean[] prev = new boolean[totalSum + 1];
        prev[0] = true;

        if (nums[0] <= totalSum)
            prev[nums[0]] = true;

        for (int i = 1; i < n; i++) {
            boolean[] temp = new boolean[totalSum + 1];
            temp[0] = true;
            for (int target = 0; target <= totalSum; target++) {
                boolean take = false;
                if (nums[i] <= target)
                    take = prev[target - nums[i]];
                boolean notTake = prev[target];

                temp[target] = (take || notTake);
            }
            prev = temp;
        }

        return prev[totalSum];
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
