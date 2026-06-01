class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {

            // Odd length
            int left = i, right = i;

            while (left >= 0 && right < n &&
                   s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            int len = right - left - 1;

            if (len > maxLen) {
                maxLen = len;
                start = left + 1;
            }

            // Even length
            left = i;
            right = i + 1;

            while (left >= 0 && right < n &&
                   s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            len = right - left - 1;

            if (len > maxLen) {
                maxLen = len;
                start = left + 1;
            }
        }

        return s.substring(start, start + maxLen);
    }
}