class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0, right = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, result = 0;

        while (right < n) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((right - left + 1) - maxFreq > k) {
                char charLeft = s.charAt(left);
                map.put(charLeft, map.get(charLeft) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
