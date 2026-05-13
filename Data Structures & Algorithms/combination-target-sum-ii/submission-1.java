class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        Arrays.sort(candidates);
        func(0, candidates.length, candidates, target, ds, res);
        return res;
    }

    private void func(int i, int n, int[] candidates, int target, List<Integer> ds, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int ind = i; ind < n; ind++) {
            if (ind > i && candidates[ind] == candidates[ind - 1])
                continue;
            
            if (candidates[ind] > target)
                break;
            
            ds.add(candidates[ind]);
            func(ind + 1, n, candidates, target - candidates[ind], ds, res);
            ds.remove(ds.size() - 1);
        }
    }
}
