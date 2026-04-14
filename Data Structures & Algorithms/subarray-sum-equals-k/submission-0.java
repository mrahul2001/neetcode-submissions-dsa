class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, count = 0;
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == k) 
                count++;

            int rem = sum - k;
            if (mpp.containsKey(rem)) {
                count += mpp.get(rem);
            }

            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}