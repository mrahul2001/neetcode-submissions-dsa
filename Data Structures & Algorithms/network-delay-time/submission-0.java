class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer, Integer>>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adjList.add(new ArrayList<>());
        
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            adjList.get(u).add(new Pair(v, wt));
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        q.add(new Pair(k, 0));

        while (!q.isEmpty()) {
            Pair<Integer, Integer> curr = q.poll();
            int node = curr.getKey();
            int steps = curr.getValue();

            for (Pair<Integer, Integer> adjValues: adjList.get(node)) {
                int adjNode = adjValues.getKey();
                int adjSteps = adjValues.getValue();

                if (adjSteps + steps < distances[adjNode]) {
                    distances[adjNode] = adjSteps + steps;
                    q.add(new Pair(adjNode, adjSteps + steps));
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for (int i = 1; i<= n; i++) {
            if (distances[i] == Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime, distances[i]);
        }

        return maxTime;
    }
}
