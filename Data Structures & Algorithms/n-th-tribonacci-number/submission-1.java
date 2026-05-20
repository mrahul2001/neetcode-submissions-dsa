class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return func(n, dp);
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