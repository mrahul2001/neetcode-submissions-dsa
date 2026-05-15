class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        
        int res = 0;
        for (int num : stones) {
            q.add(num);
            res += num;
        }
            
        if (q.size() < 2) {
            return q.peek();
        }
        
        while (!q.isEmpty()) {
            int largest = q.poll();
            int largest2 = q.poll();
            if (largest == largest2) {
                res -= (largest + largest2);
            } else if (largest > largest2) {
                res -= (largest + largest2);
                res += (largest - largest2);
                q.add(largest - largest2);
            }

            if (q.size() == 1) {
                return res;
            }
        }

        return 0;
    }
}
