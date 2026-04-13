class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        func(1, n, k, ds, result);

        return result;
    }

    private void func(int ind, int n, int k, List<Integer> ds, List<List<Integer>> result) {
        if (ds.size() == k) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i <= n; i++) {
            ds.add(i);
            func(i + 1, n, k, ds, result);
            ds.remove(ds.size() - 1);
        }
    }
}