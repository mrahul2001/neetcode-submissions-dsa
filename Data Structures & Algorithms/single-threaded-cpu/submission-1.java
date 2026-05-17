class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        } 

        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int time = tasks[0][0], i = 0;

        while (!q.isEmpty() || i < n) {
            while (i < n && time >= tasks[i][0]) {
                q.add(new int[]{tasks[i][1], tasks[i][2]});
                i++;
            }

            if (q.isEmpty()) {
                time = tasks[i][0];
            } else {
                int[] task = q.poll();
                time += task[0];
                res.add(task[1]);
            }
        }

        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}