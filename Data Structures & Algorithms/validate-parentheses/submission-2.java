class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque();

        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            
            if(!stk.isEmpty() && isRemovable(stk.peek(), c)) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        return stk.isEmpty();
    }

    private boolean isRemovable(char c, char d) {
        boolean type1 = c == '(' && d == ')';
        boolean type2 = c == '{' && d == '}';
        boolean type3 = c == '[' && d == ']';
        return type1 || type2 || type3;
    }
}
