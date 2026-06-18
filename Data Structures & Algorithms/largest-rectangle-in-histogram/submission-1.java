class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<int[]> stk = new ArrayDeque<>();

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int idx = i;
            while (!stk.isEmpty() && stk.peek()[0] > heights[i]) {
                int[] pop = stk.pop();
                int h = pop[0];
                int width = i - pop[1];

                maxArea = Math.max(maxArea, width * h);
                idx = pop[1];
            }

            stk.push(new int[] {heights[i], idx});
        }

        while (!stk.isEmpty()) {
            int[] pop = stk.pop();
            int h = pop[0];
            int width = heights.length - pop[1];

            maxArea = Math.max(maxArea, h * width);
        }

        return maxArea;
    }
}
