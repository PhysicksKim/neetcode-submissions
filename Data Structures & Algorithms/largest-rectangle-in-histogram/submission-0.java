class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<int[]> stk = new ArrayDeque<>();

        int maxArea = heights[0];
        stk.add(arr(heights[0],0));

        for(int i = 1 ; i < heights.length ; i++) {
            int h = heights[i];
            maxArea = Math.max(maxArea,h);
            int idx = i;

            while(!stk.isEmpty() && h < stk.peek()[0]) {
                int[] pop = stk.pop();
                idx = pop[1];
                int popH = pop[0];
                int popIdx = pop[1];

                int area = popH * (i-popIdx);
                maxArea = Math.max(maxArea,area);
            }

            stk.push(arr(h,idx));
        }

        while(!stk.isEmpty()) {
            int[] pop = stk.pop();
            int popH = pop[0];
            int popIdx = pop[1];

            int area = popH * (heights.length-popIdx);
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }

    private int[] arr(int h, int idx) {
        return new int[]{h,idx};
    }
}
