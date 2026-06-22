class FreqStack {
    Map<Integer, Integer> mpp;
    Map<Integer, Stack<Integer>> stacks;
    int maxFreq;

    public FreqStack() {
        mpp = new HashMap<>();
        stacks = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int valFreq = mpp.getOrDefault(val, 0) + 1;
        mpp.put(val, valFreq);

        if (valFreq > maxFreq) {
            maxFreq = valFreq;
            stacks.putIfAbsent(valFreq, new Stack<>());
        }
        stacks.get(valFreq).push(val);
    }
    
    public int pop() {
        int res = stacks.get(maxFreq).pop();
        mpp.put(res, mpp.get(res) - 1);

        if (stacks.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */