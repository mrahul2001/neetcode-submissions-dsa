class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] dp = new Boolean[n];

        return func(0, s, wordDict, dp);
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
