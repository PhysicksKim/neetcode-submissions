class MinStack {

    Deque<Integer> stk;
    Deque<Integer> minStk;

    public MinStack() {
        stk = new ArrayDeque();
        minStk = new ArrayDeque();
    }
    
    public void push(int val) {
        stk.push(val);
        if(minStk.isEmpty() || val <= minStk.peek()) {
            minStk.push(val);
        }
    }
    
    public void pop() {
        int val = stk.pop();
        if(minStk.peek() == val) {
            minStk.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }

}
