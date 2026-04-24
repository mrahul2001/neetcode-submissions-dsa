class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        if (dfs(0, -1, adjList, visited))
            return false;

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        for (int adjNode : adjList.get(node)) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, node, adjList, visited))
                    return true;
            } else if (adjNode != parent) {
                return true;
            }
        }
        return false;
    }
}