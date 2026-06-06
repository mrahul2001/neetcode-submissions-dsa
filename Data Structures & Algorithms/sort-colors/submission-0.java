class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            switch(nums[mid]) {
                case 0:
                    swap(low, mid, nums);
                    low++;
                    mid++;
                    break;
                
                case 1:
                    mid++;
                    break;
                
                case 2:
                    swap(mid, high, nums);
                    high--;
            }
        }
    }

    private void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}