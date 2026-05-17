class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        for (int i = 0; i < n; i++) 
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};

        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        int[] res = new int[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0, idx = 0;
        int time = tasks[0][0];

        while (!pq.isEmpty() || i < n) {
            while (i < n && time >= tasks[i][0]){
                pq.add(new int[]{tasks[i][1], tasks[i][2]});
                i++;
            }
            
            if (pq.isEmpty()) {
                time = tasks[i][0];
            } else {
                int[] task = pq.poll();
                time += task[0];
                res[idx] = task[1];
                idx++;
            }
        }

        return res;
    }
}