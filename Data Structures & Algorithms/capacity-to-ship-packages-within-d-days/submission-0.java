class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt(); 
        int high = Arrays.stream(weights).sum();

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (calculate(mid, weights) <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;                
            }
        }

        return ans;
    }

    private int calculate(int capacity, int[] weights) {
        int totalDays = 1, load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] + load > capacity) {
                totalDays++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return totalDays;
    }
}