class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return func(target, nums, dp);
    }

    private int func(int tar, int[] nums, int[] dp) {
        if (tar == 0)
            return 1;
        
        if (dp[tar] != -1)
            return dp[tar];
        
        int ways = 0;
        for (int num : nums) {
            if (num <= tar) {
                ways += func(tar - num, nums, dp);
            }
        }

        return dp[tar] = ways;
    }
}