class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = Arrays.stream(matchsticks).sum();

        if (sum % 4 != 0)
            return false;
        
        int[] sides = new int[4];
        int sideLen = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return func(0, n, sideLen, sides, matchsticks);
    }

    private boolean func(int i, int n, int sideLen, int[] sides, int[] matchsticks) {
        if (i == n)
            return Arrays.stream(sides).allMatch(x -> x == sides[0]);
        
        for (int j = 0; j < 4; j++) {
            if (sides[j] + matchsticks[i] <= sideLen) {
                sides[j] += matchsticks[i];
                if (func(i + 1, n, sideLen, sides, matchsticks))
                    return true;
                sides[j] -= matchsticks[i];
            }
        }

        return false;
    }

    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }
}