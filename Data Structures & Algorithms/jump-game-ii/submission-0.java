class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int res = 0, left = 0, right = 0;

        while (right < n - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }

            left = right + 1;
            right = farthest;
            res++;
        }

        return res;
    }
}
