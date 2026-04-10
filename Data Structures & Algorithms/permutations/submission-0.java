class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] pick = new boolean[n];

        perms(0, n, nums, pick, ds, result);

        return result;
    }

    private void perms(int ind, int n, int[] nums, boolean[] pick, List<Integer> ds, List<List<Integer>> result) {
        if (ds.size() == n) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!pick[i]) {
                ds.add(nums[i]);
                pick[i] = true;
                perms(i + 1, n, nums, pick, ds, result);
                ds.remove(ds.size() - 1);
                pick[i] = false;
            }

        }
    }
}
