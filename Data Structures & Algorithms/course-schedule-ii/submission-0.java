class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] res = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int currNode = q.poll();
            res[i++] = currNode;

            for (int adjNode: adjList.get(currNode)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0)
                    q.add(adjNode);
            }
        }

        return i == numCourses ? res : new int[]{};
    }
}
