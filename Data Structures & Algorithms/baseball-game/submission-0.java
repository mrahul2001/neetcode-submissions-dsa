class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        int res = 0;
        for (String it : operations) {
            if (it.equals("+")) {
                int top = st.pop();
                int newTop = top + st.peek();
                st.push(top);
                st.push(newTop);
                res += newTop;
            } else if (it.equals("D")) {
                st.push(2 * st.peek()); 
                res += st.peek();
            } else if (it.equals("C")) {
                int val = st.pop();
                res -= val;
            } else {
                st.push(Integer.parseInt(it));
                res += Integer.parseInt(it);
            }
        }

        return res;
    }
}