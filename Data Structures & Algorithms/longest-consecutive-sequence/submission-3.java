class Solution {
    public int longestConsecutive(int[] nums) {
        int lcs = 0;

        Set<Integer> st = new HashSet<>();
        for (int num : nums)
            st.add(num);
        
        for (int num : st) {
            if (!st.contains(num - 1)) {
                int cnt = 1;
                int curr = num;

                while (st.contains(curr + 1)) {
                    curr++;
                    cnt++;
                }

                lcs = Math.max(lcs, cnt);
            }
        }

        return lcs;
    }
}
