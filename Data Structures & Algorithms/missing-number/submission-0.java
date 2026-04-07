class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 1, xor2 = 1;

        for (int i = 0; i < nums.length; i++) {
            xor1 ^= nums[i];
            xor2 ^= (i + 1);
        }

        return xor1 ^ xor2;
    }
}
