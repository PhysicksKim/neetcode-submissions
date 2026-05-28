class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final int[] in = temperatures;
        int[] answer = new int[in.length];
        answer[in.length-1] = 0;

        for(int i = in.length-2 ; i >= 0 ; i--) {
            if(in[i+1] > in[i]) {
                answer[i] = 1;
                continue;
            }

            int p = i + answer[i+1];
            while(in[p] <= in[i] && answer[p] != 0) {
                p += answer[p];
            }
            
            if(in[p] > in[i]) {
                answer[i] = p-i;
            } else{
                answer[i] = 0;
            }
        }

        return answer;
    }
}
