class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> ds = new ArrayList<>();

        func(0, s, ds, result);

        return result;
    }

    private void func(int ind, String s, List<String> ds, List<List<String>> result) {
        if (ind == s.length()) {
            result.add(new ArrayList<>(ds));
            return;
        }

        StringBuilder temp = new StringBuilder();
        for (int i = ind; i < s.length(); i++) {
            temp.append(s.charAt(i));

            if (isPalindrome(s, ind, i)) {
                ds.add(temp.toString());
                func(i + 1, s, ds, result);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}
