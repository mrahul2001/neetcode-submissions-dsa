class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            for (int j = 0; j < w1.length(); j++) {
                if (j == w2.length())
                    return false;
                
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (map.get(w1.charAt(j)) > map.get(w2.charAt(j)))
                        return false;
                    break;
                }
            }
        }

        return true;
    }
}