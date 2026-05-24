class Solution {
    
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>(); 

        for(int i = 0 ; i < tokens.length ; i++) {
            if(isOperator(tokens[i])) {
                int b = stk.pop();
                int a = stk.pop();
                int val = operate(a,b,tokens[i]);
                stk.push(val);
            } else {
                stk.push(Integer.parseInt(tokens[i]));
            }
        }

        return stk.pop();
    }

    private int operate(int a, int b, String ope) {
        switch (ope) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: return a / b;
        }
    }

    private boolean isOperator(String s) {
        switch(s) {
            case "+" : case "-" : case "*" : case "/" :
                return true;
            default : 
                return false;
        }
    }

}
