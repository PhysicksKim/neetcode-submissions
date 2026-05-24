class MinStack {

    Deque<int[]> stk;

    public MinStack() {
        stk = new ArrayDeque();
    }
    
    public void push(int val) {
        if(stk.isEmpty()) {
            stk.push(e(val,val));
            return;
        }

        int min = Math.min(stk.peek()[1], val);
        stk.push(e(val,min));
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek()[0];
    }
    
    public int getMin() {
        return stk.peek()[1];
    }

    private int[] e(int val, int min) {
        return new int[]{val, min};
    }

}
