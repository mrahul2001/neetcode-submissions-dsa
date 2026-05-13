class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        func(1, n, k, ds, res);
        return res;
    }

    private void func(int ind, int n, int k, List<Integer> ds, List<List<Integer>> res) {
        if (ds.size() == k) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i <= n; i++) {
            ds.add(i);
            func(i + 1, n, k, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
}