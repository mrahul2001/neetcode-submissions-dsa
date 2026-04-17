class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            maxLength = Math.max(maxLength, (right - left + 1));
            map.put(ch, right);
            right++;
        }

        return maxLength;
    }
}
