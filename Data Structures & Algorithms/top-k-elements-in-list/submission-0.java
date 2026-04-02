class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>(); 
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
            arr.add(new int[] {entry.getValue(), entry.getKey()}); 
        } 
        
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}
