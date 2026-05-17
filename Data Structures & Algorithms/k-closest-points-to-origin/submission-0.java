class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> dist(b) - dist(a));

        for (int[] point : points) {
            Double x = Math.pow(point[0], 2);
            Double y = Math.pow(point[1], 2);

            q.add(new int[]{point[0], point[1]});

            if (q.size() > k)
                q.poll();
        }

        int[][] res = new int[k][2];
        int ind = 0;
        while (!q.isEmpty()) {
            res[ind] = q.poll();
            ind++;
        }

        return res;
    }

    private int dist(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}
