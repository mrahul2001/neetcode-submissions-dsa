class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;

        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        return st.size()!=nums.length;
    }
}