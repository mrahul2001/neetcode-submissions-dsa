class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());
        
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adjList.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        List<Set<Integer>> preSet = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            preSet.add(new HashSet<>());

                while (!q.isEmpty()) {

            int curr = q.poll();

            for (int adjNode : adjList.get(curr)) {

                // direct prerequisite
                preSet.get(adjNode).add(curr);

                // inherited prerequisites
                preSet.get(adjNode).addAll(preSet.get(curr));

                indegree[adjNode]--;

                if (indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {

            int u = query[0];
            int v = query[1];

            result.add(preSet.get(v).contains(u));
        }

        return result;
    }
}