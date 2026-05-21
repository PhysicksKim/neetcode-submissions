class Solution {

    private int[] h;
    int maxL,maxR,L,R;

    public int maxArea(int[] heights) {
        this.h = heights;
        L = 0;
        R = heights.length-1;
        maxL = L;
        maxR = R;
        int maxArea = getArea(L,R);
        shiftIdx();

        while(L < R) {
            int nowArea = getArea(L,R);
            if(nowArea > maxArea) {
                maxL = L; maxR = R;
                maxArea = nowArea;
            }
            shiftIdx();
        }

        return maxArea;
    }

    private int getArea(int left, int right) {
        return Math.min(h[left],h[right])*(right-left);
    }

    private void shiftIdx() {
        if(h[L] > h[R]) { 
            R--;
        } else {
            L++;
        }
    }
}
