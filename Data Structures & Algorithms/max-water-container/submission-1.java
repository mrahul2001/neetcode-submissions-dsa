class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n - 1;
        int maxWater = Integer.MIN_VALUE;

        while (left < right) {
            int width = right - left;
            maxWater = Math.max(maxWater, width * Math.min(heights[right], heights[left])) ;

            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
