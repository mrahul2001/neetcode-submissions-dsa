class MinStack {

    Stack<Long> st;
    long mini;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {

        if (st.isEmpty()) {
            st.push((long) val);
            mini = val;
            return;
        }

        if (val >= mini) {
            st.push((long) val);
        } else {
            st.push(2L * val - mini);
            mini = val;
        }
    }

    public void pop() {

        long top = st.pop();
        if (top < mini) {
            mini = 2 * mini - top;
        }
    }

    public int top() {

        long top = st.peek();
        if (top < mini)
            return (int) mini;

        return (int) top;
    }

    public int getMin() {
        return (int) mini;
    }
}