class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        if (n1 != n2)
            return false;
        
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0)
                return false;
            
            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }
}
