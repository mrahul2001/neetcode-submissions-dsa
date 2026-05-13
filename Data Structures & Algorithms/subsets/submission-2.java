class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        func(0, nums.length, nums, ds, res);
        return res;
    }    

    private void func(int i, int n, int[] nums, List<Integer> ds, List<List<Integer>> res) {
        
        if (i == n) {
            res.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[i]);
        func(i + 1, n, nums, ds, res);
        ds.remove(ds.size() - 1);
        func(i + 1, n, nums, ds, res);
    }
}
