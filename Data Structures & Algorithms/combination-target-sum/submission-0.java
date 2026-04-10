class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       int n = nums.length;
       List<Integer> ds = new ArrayList<>();

       combSum(0, target, nums, ds, n);
       return result;
    }

    private void combSum(int i, int target, int[] nums, List<Integer> ds, int n) {
        if (i == n) {
            if (target == 0)
                result.add(new ArrayList<>(ds));
            return;
        }

        if (nums[i] <= target) {
            ds.add(nums[i]);
            combSum(i, target - nums[i], nums, ds, n);
            ds.remove(ds.size() - 1);
        }
        combSum(i + 1, target, nums, ds, n);
    }
}
