class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[n + 1];
        map.forEach((key, value)-> {
            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }); 

        int index = 0;
        int[] res = new int[k];
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[index] = num;
                    index++;
                    if (index == k)
                        break;
                }
            }
        }

        return res;
    }
}
