class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] pick = new boolean[n];

        Arrays.sort(nums);
        perms(n, nums, pick, ds, result);

        return result;
    }

    private void perms(int n, int[] nums, boolean[] pick, List<Integer> ds, List<List<Integer>> result) {
        if (ds.size() == n) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !pick[i - 1])    continue;

            if (!pick[i]) {
                ds.add(nums[i]);
                pick[i] = true;
                perms(n, nums, pick, ds, result);
                ds.remove(ds.size() - 1);
                pick[i] = false;
            }
        }
    }
}