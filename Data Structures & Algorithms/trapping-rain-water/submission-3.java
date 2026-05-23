class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int floorIdx = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int leftWallIdx = stack.peek();

                int boundedHeight = Math.min(height[leftWallIdx], height[i]) - height[floorIdx];
                int width = i - leftWallIdx - 1;

                sum += boundedHeight * width;
            }

            stack.push(i);
        }

        return sum;
    }
}