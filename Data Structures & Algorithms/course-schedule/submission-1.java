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

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int node : adjList.get(i))
                indegree[node]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int currNode = q.poll();
            res.add(currNode);

            for (int adjNode: adjList.get(currNode)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0)
                    q.add(adjNode);
            }
        }

        return res.size() == numCourses;
    }
}
