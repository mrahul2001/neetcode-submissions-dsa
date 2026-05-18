class Solution {

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair<Integer, Character>> q = new PriorityQueue<>((x, y) -> y.getKey() - x.getKey());

        if (a > 0) q.add(new Pair<>(a, 'a'));
        if (b > 0) q.add(new Pair<>(b, 'b'));
        if (c > 0) q.add(new Pair<>(c, 'c'));

        StringBuilder res = new StringBuilder();

        while (!q.isEmpty()) {
            Pair<Integer, Character> first = q.poll();

            if (res.length() > 1 &&
                res.charAt(res.length() - 1) == first.getValue() &&
                res.charAt(res.length() - 2) == first.getValue()) {

                if (q.isEmpty()) 
                    break;
                

                Pair<Integer, Character> second = q.poll();
                int freq = second.getKey();
                char ch = second.getValue();
                res.append(ch);
                freq--;
                if (freq > 0) 
                    q.add(new Pair<>(freq, ch));

                q.add(first);

            } else {

                res.append(first.getValue());
                int freq = first.getKey() - 1;
                if (freq > 0) 
                    q.add(new Pair<>(freq, first.getValue()));
            }
        }

        return res.toString();
    }
}