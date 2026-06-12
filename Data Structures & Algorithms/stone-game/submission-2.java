class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        
        int total = 0;
        for (int pile : piles)
            total += pile;

        int[][] dp = new int[n][n];
        for (int[] it : dp)
            Arrays.fill(it, -1);
        
        int aliceScore = func(0, n - 1, piles, dp);
        int bobScore = total - aliceScore;

        return aliceScore > bobScore;
    }

    private int func(int i, int j, int[] piles, int[][] dp) {
        if (i > j)
            return 0;
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        boolean even = (j - i) % 2 == 0;

        int left = even ? piles[i] : 0;
        int right = even ? piles[j] : 0;

        return dp[i][j] = Math.max(func(i + 1, j, piles, dp) + left,
            func(i, j - 1, piles, dp) + right); 
    }
}