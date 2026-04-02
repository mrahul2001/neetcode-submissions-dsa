class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        int lcs = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                int count = 1;
                
                int curr = it;
                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                lcs = Math.max(lcs, count);
            }
        }

        return lcs;
    }
}
