class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);

        int cnt = 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            int sum = people[left] + people[right];

            if (sum <= limit) {
                left++;
            } 
                
            right--;
            cnt++;
        }
        return cnt;
    }
}