class Solution {
    int xorRes = 0;
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();

        xorSum(0, nums, ds, n);
        return xorRes;
    }

    private void xorSum(int i, int[] nums, List<Integer> ds, int n) {
        if (i == n) {
            int xorVal = 0;
            for (int item : ds) {
                xorVal ^= item;
            }
            xorRes += xorVal;
            return;
        }

        ds.add(nums[i]);
        xorSum(i + 1, nums, ds, n);
        ds.remove(ds.size() - 1);
        xorSum(i + 1, nums, ds, n);
    }
}