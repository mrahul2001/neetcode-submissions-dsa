class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, numCourses, adjList, visited, pathVisited))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int numCourses, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int adjNode : adjList.get(node)) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, numCourses, adjList, visited, pathVisited))
                    return true;
            } else if (pathVisited[adjNode])
                return true;
        }

        pathVisited[node] = false;
        return false;
    }
}
