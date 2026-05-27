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
            if(LMAX <= h[L]) {
                LMAX = h[L];
                L++;
                continue;
            } 
            if (RMAX <= h[R]) {
                RMAX = h[R];
                R--; 
                continue;
            }

            if(h[L] < LMAX && LMAX <= RMAX) {
                sum += (LMAX - h[L]);
                L++;
                continue; 
            }
            if(h[R] < RMAX && RMAX <= LMAX) {
                sum += (RMAX - h[R]);
                R--;
                continue;
            }

            throw new IllegalStateException();
        }
        return sum;
    }
}
