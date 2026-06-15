class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && !st.isEmpty() &&
            asteroid < 0 && st.peek() > 0) {

                if (st.peek() < Math.abs(asteroid)) {
                    st.pop();
                } else if (st.peek() == Math.abs(asteroid)) {
                    st.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive)
                st.push(asteroid);
        }

        return st.stream().mapToInt(i -> i).toArray();
    }
}