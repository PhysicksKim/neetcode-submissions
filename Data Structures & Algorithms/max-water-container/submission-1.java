public class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while(left < right) {
            int nowArea = Math.min(heights[left], heights[right]) * (right - left);
            if(nowArea > maxArea) {
                maxArea = nowArea;
            }
            if(heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}