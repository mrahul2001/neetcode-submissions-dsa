class Solution {

    public int lastStoneWeightII(int[] stones) {

        int n = stones.length;
        int totalSum = Arrays.stream(stones).sum();

        int target = totalSum / 2;

        int[][] dp = new int[n][target + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);

        for (int s1 = target; s1 >= 0; s1--) {

            if (func(n - 1, s1, stones, dp)) {
                return totalSum - 2 * s1;
            }
        }

        return 0;
    }

    private boolean func(int i, int sum, int[] stones, int[][] dp) {
        if (sum == 0)
            return true;

        if (i == 0)
            return stones[0] == sum;

        if (dp[i][sum] != -1)
            return dp[i][sum] == 1 ? true : false;

        boolean notTake = func(i - 1, sum, stones, dp);

        boolean take = false;

        if (stones[i] <= sum)
            take = func(i - 1, sum - stones[i], stones, dp);

        dp[i][sum] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }
}