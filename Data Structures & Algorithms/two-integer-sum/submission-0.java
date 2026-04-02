class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int remaining = target - num;

            if (map.containsKey(remaining)) {
                return new int[]{map.get(remaining), i};
            }

            map.put(num, i);
        }

        return new int[]{-1, -1};
    }
}
