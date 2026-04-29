class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        if (deadendSet.contains("0000"))
            return -1;
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair("0000", 0));

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while(!q.isEmpty()) {
            Pair<String, Integer> curr = q.poll();
            String currComb = curr.getKey();
            int currMoves = curr.getValue();

            if (currComb.equals(target))
                return currMoves;
            
            for (int i = 0; i < 4; i++) {
                for (int delta : new int[]{-1, 1}) {
                    int newDigit = (currComb.charAt(i) - '0' + delta + 10) % 10;
                    String newComb = currComb.substring(0, i) +
                                    String.valueOf(newDigit) +
                                    currComb.substring(i + 1);
                    
                    if (!visited.contains(newComb) && !deadendSet.contains(newComb)) {
                        visited.add(newComb);
                        q.add(new Pair(newComb, currMoves + 1));
                    }
                }
            }
        }
        return -1;
    }
}