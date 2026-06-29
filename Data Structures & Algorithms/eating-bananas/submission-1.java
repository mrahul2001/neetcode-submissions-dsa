class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (time(mid, piles) <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int time(int mid, int[] piles) {
        int timeTaken = 0;
        for (int i = 0; i < piles.length; i++) {
            timeTaken += Math.ceil((double) piles[i] / mid);
        }

        return timeTaken;
    }
}
