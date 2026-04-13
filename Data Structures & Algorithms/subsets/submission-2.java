class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        func(0, n, nums, ds, result);

        return result;
    }

    private void func(int i, int n, int[] nums, List<Integer> ds, List<List<Integer>> result) {
        if (i == n) {
            result.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[i]);
        func(i + 1, n, nums, ds, result);
        ds.remove(ds.size() - 1);
        func(i + 1, n, nums, ds, result);
    } 
}
