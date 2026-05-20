class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0)
                temp1[a++] = nums[i];
            if (i != n - 1)
                temp2[b++] = nums[i];
        }
        
        return Math.max(func(temp1), func(temp2));
    }

    public int func(int[] nums) {
        int n = nums.length;

        int prev0 = nums[0];
        int prevNeg = 0;

        for (int i = 1; i < n; i++) {
            int take = nums[i] + prevNeg;
            int notTake = prev0;

            int curr = Math.max(take, notTake);
            prevNeg = prev0;
            prev0 = curr;
        }

        return prev0;
    }
}
