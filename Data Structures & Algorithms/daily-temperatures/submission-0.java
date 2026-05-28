class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final int[] in = temperatures;
        Deque<int[]> stk = new ArrayDeque<>();

        int[] answer = new int[in.length];

        for(int i = in.length-1 ; i >= 0 ; i--) {
            int now = in[i];

            while(!stk.isEmpty() && stk.peek()[1] <= now) {
                stk.pop();
            }

            if(stk.isEmpty()) {
                answer[i] = 0;
                stk.push(new int[]{i,now});
                continue;
            }

            // stk is not empty
            int idx = stk.peek()[0];
            answer[i] = idx-i;
            stk.push(new int[]{i,now});
        }  

        return answer;
    }
}
