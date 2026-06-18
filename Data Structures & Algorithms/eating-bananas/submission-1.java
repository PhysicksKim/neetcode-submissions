class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int L = 1, R = maxOf(piles);

        while(L<R) {
            int mid = L + (R-L)/2;
            
            int nowH = calcHour(piles, mid);
            if(nowH <= h) {
                R = mid;
            } else {
                L = mid+1;
            }
        }

        return L;
    }

    private int calcHour(int[] arr, int v) {
        int sum = 0;
        for(int e : arr) {
            sum += (e/v + (e%v == 0 ? 0 : 1));
        }
        return sum;
    }

    private int maxOf(int[] piles) {
        int max = 0;
        for(int e : piles) {
            max = Math.max(e,max);
        }
        return max;
    }
}
