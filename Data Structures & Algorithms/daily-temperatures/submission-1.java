class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final int[] in = temperatures;
        Deque<int[]> stk = new ArrayDeque<>();

        int[] answer = new int[in.length];

        for(int i = 0 ; i < in.length ; i++) {
            int now = in[i];
            while(!stk.isEmpty() && stk.peek()[0] < now) {
                int[] pop = stk.pop();
                answer[pop[1]] = i - pop[1];
            }
            stk.push(new int[]{now,i});
        }

        return answer;
    }
}
