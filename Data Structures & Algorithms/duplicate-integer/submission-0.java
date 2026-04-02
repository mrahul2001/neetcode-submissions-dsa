class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) 
            set.add(nums[i]);
        
        return n != set.size();
    }
}