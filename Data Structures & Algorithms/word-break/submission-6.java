class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    if (dp[i + w.length()]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }

    private boolean func(int i, String s, List<String> wordDict, Boolean[] dp) {
        if (i == s.length())
            return true;

        if (dp[i] != null)
            return dp[i];

        for (String w : wordDict) {
            if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                if (func(i + w.length(), s, wordDict, dp))
                    return dp[i] = true;
            }
        }

        return dp[i] = false;
    }
}
