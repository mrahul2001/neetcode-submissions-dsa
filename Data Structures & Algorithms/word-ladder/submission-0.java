class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++)
            st.add(wordList.get(i));
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        st.remove(beginWord);

        while (!q.isEmpty()) {
            Pair<String, Integer> curr = q.poll();
            String word = curr.getKey();
            int steps = curr.getValue();

            if (word.equals(endWord))
                return steps;
            
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;

                    String replacedWord = String.valueOf(replacedCharArray);
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}
