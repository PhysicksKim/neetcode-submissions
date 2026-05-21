class Solution {
    public int trap(int[] height) {
        final int LEN = height.length;
        
        int[] leftArr = new int[LEN];
        int[] rightArr = new int[LEN];

        int L = 0, R = LEN-1;
        int leftMax = height[L];
        int rightMax = height[R];

        while(L < LEN) {
            // left
            if(height[L] > leftMax) {
                leftArr[L] = height[L];
                leftMax = height[L];
            } else {
                leftArr[L] = leftMax;
            }

            // right
            if(height[R] > rightMax) {
                rightArr[R] = height[R];
                rightMax = height[R];
            } else {
                rightArr[R] = rightMax;
            }

            L++; R--;
        }

        int sum = 0;
        for(int i = 0 ; i < LEN ; i++) {
            sum += Math.min(leftArr[i], rightArr[i]) - height[i];
        }

        return sum;
    }
}
