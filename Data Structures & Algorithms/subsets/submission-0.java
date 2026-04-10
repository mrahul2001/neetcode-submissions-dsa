class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();

        powerSet(0, nums, ds, n);
        return result;
    }

    private void powerSet(int i, int[] nums, List<Integer> ds, int n) {
        if (i == n) {
            result.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[i]);
        powerSet(i + 1, nums, ds, n);
        ds.remove(ds.size() - 1);
        powerSet(i + 1, nums, ds, n);
    }
}
