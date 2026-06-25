class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word: words) {
            for (char ch : word.toCharArray()) {
                adjList.putIfAbsent(ch, new HashSet<>());
                indegree.put(ch, 0);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() &&
            w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            
            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!adjList.get(c1).contains(c2)) {
                        adjList.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0)
                q.add(ch);
        }

        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            char node = q.poll();
            res.append(node);

            for (char adjNode: adjList.get(node)) {
                indegree.put(adjNode, indegree.get(adjNode) - 1);

                if (indegree.get(adjNode) == 0)
                    q.add(adjNode);
            }
        }

        if (res.length() != indegree.size())
            return "";
        
        return res.toString();
    }
}
