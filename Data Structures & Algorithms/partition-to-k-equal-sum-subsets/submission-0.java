class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum % k != 0)
            return false;
        
        int partLen = sum / k;
        Arrays.sort(nums);
        reverse(nums, 0, n - 1);
        int[] parts = new int[k];

        return func(0, n, k, partLen, parts, nums);
    }

    private boolean func(int i, int n, int k, int partLen, int[] parts, int[] nums) {
        if (i == n) 
            return Arrays.stream(parts).allMatch(x -> x == parts[0]);
        
        for (int j = 0; j < k; j++) {
            if (parts[j] + nums[i] <= partLen) {
                parts[j] += nums[i];

                if (func(i + 1, n, k, partLen, parts, nums))
                    return true;
                
                parts[j] -= nums[i];
            }
        }
        return false;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}