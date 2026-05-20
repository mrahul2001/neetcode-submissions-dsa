class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        int prev0 = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= n; i++) {
            int curr = prev0 + prev1 + prev2;
            prev0 = prev1;
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }

    private int func(int i, int[] dp) {
        if (i == 0 || i == 1 || i == 2)
            return i == 0 ? 0 : 1;

        if (dp[i] != -1)
            return dp[i];

        int step1 = func(i - 1, dp);
        int step2 = func(i - 2, dp);
        int step3 = func(i - 3, dp);

        return dp[i] = step1 + step2 + step3;
    }
}