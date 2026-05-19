class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int i = 0, j = 0;

        StringBuilder res = new StringBuilder();
        while (i < l1 && j < l2) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(j));

            i++;
            j++;
        }

        if (i < l1) {
            res.append(word1.substring(i, l1));
        }

        if (j < l2) {
            res.append(word2.substring(j, l2));
        }

        return res.toString();
    }
}