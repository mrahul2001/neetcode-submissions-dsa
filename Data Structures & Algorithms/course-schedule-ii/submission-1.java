class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());
        
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) 
                if (dfs(i, visited, pathVisited, st, adjList))
                    return new int[]{};
        }

        int[] result = new int[numCourses];
        int i = 0;
        while (!st.isEmpty()) {
            result[i++] = st.pop();
        }

        return result;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] pathVisited, Stack<Integer> st, List<List<Integer>> adjList) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int adjNode : adjList.get(node)) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, visited, pathVisited, st, adjList))
                    return true;
            } else if (pathVisited[adjNode])
                return true;
            
        }

        pathVisited[node] = false;
        st.push(node);
        return false;
    }
}