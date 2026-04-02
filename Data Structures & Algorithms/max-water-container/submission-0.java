class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = n - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));

            if (heights[left] <= heights[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
