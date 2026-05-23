class Solution {

    public int trap(int[] height) {
        Stack<int[]> stk = new Stack();

        int sum = 0;
        for(int i = 0 ; i < height.length ; i++) {
            int now = height[i];

            while(!stk.empty() && stk.peek()[1] < now) {
                int[] floor = stk.pop();
                if(stk.empty()) {
                    break;
                }

                int[] leftWall = stk.pop();
                while(!stk.empty() && stk.peek()[1] == floor[1]) {
                    leftWall = stk.pop();
                }

                int waterH = Math.min(leftWall[1], now) - floor[1];
                int width = i - leftWall[0] - 1;

                sum += waterH * width;
                stk.push(leftWall);
            } 

            stk.push(new int[]{i, height[i]});
        }

        return sum;
    }

}
