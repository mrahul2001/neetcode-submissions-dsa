class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        for (int j = n - 1; j >= 0; j--) {
            result[j] *= suffix;
            suffix *= nums[j];
        }

        return result;
    }
}  
