class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int ls = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while (right < n) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                ls = Math.max(ls, (right - left + 1));
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                right++;
            } else {
               while (map.containsKey(ch)) {
                    char leftChar = s.charAt(left);
                    map.remove(leftChar);
                    left++;
                }
            }
        }

        return ls;
    }
}
