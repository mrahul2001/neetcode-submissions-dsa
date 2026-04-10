class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        Arrays.sort(nums);
        combSum(0, target, nums, ds, n, result);

        return result;
    }

    private void combSum(int i, int target, int[] nums, List<Integer> ds, int n, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int ind = i; ind < n; ind++) {
            if (ind > i && nums[ind] == nums[ind - 1])  continue;
            if (nums[ind] > target) break;

            ds.add(nums[ind]);
            combSum(ind + 1, target - nums[ind], nums, ds, n, result);
            ds.remove(ds.size() - 1);
        }
    }
}
