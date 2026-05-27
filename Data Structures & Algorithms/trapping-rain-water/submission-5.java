class Solution {
    public int trap(int[] height) {
        final int LEN = height.length;
        final int[] h = height;
        int L = 0;
        int R = LEN-1;
        int LMAX = h[L], RMAX = h[R];
        L++; R--;
        
        int sum = 0;
        while(L<=R) {
            if(LMAX < RMAX) {
                if(h[L] < LMAX) {
                    sum += (LMAX - h[L]);
                } else {
                    LMAX = h[L];
                }
                L++;
            } else {
                if(h[R] < RMAX) {
                    sum += (RMAX - h[R]);
                } else {
                    RMAX = h[R];
                }
                R--;
            }
        }

        return sum;
    }
}
