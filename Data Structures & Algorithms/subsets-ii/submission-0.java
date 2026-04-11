class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        subSum(0, n, nums, ds, result);

        return result;
    }

    private void subSum(int ind, int n, int[] nums, List<Integer> ds, List<List<Integer>> result) {
        result.add(new ArrayList<>(ds));

        for (int i = ind; i < n; i++) {
            if (i > ind && nums[i] == nums[i - 1])  continue;

            ds.add(nums[i]);
            subSum(i + 1, n, nums, ds, result);
            ds.remove(ds.size() - 1);
        }
    }
}
