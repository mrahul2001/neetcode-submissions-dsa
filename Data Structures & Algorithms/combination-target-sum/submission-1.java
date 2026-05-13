class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        func(0, nums.length, nums, target, ds, res);
        return res;
    }

    private void func(int i, int n, int[] nums, int target, List<Integer> ds, List<List<Integer>> res) {
        if (i == n) {
            if (target == 0)
                res.add(new ArrayList<>(ds));
            return;
        }

        if (target >= nums[i]) {
            ds.add(nums[i]);
            func(i, n, nums, target - nums[i], ds, res);
            ds.remove(ds.size() - 1);
        }
        func(i + 1, n, nums, target, ds, res);
    }
}
