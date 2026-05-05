class Solution {
    int result = 0;
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();

        func(0, n, nums, ds);

        return result;
    }

    private void func(int i, int n, int[] nums, List<Integer> ds) {
        if (i == n) {
            int xorVal = 0;
            for (int item : ds) {
                xorVal ^= item;
            }

            result += xorVal;
            return;
        }

        ds.add(nums[i]);
        func(i + 1, n, nums, ds);
        ds.remove(ds.size() - 1);
        func(i + 1, n, nums, ds);
    }
}