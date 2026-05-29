class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = Arrays.stream(nums).sum();

        if (totalSum < target || (totalSum + target) % 2 != 0)
            return 0;

        return func(n - 1, (totalSum + target) / 2, nums);
    }

    private int func(int i, int target, int[] nums) {
        if (i == 0) {
            if (target == 0 && nums[0] == 0)
                return 2;

            if (target == 0 || nums[0] == target)
                return 1;

            return 0;
        }

        int take = 0;
        if (nums[i] <= target)
            take = func(i - 1, target - nums[i], nums);
        int notTake = func(i - 1, target, nums);

        return take + notTake;
    }
}
