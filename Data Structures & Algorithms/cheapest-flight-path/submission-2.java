class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            adjList.get(u).add(new Pair(v, wt));
        }

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int price = curr[1];
            int stops = curr[2];

            if (stops > k)
                continue;
            
            for (Pair<Integer, Integer> adjNode : adjList.get(node)) {
                int nextNode = adjNode.getKey();
                int nextPrice = adjNode.getValue();

                if (price + nextPrice < distances[nextNode]) {
                    distances[nextNode] = price + nextPrice;
                    q.add(new int[]{nextNode, price + nextPrice, stops + 1});
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}
