class Solution {
    public int findMin(int[] nums) {
        final int LEN = nums.length;

        // 이진탐색 준비 : LR 포인터 
        // 경계는 ..,6,1,.. 같이 수렴함. 
        int L = 0, R = LEN-1;

        while(L<R) {
            int mid = L+(R-L)/2;
            int midVal = nums[mid];
            int RVal = nums[R];

            if(midVal > RVal) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }

        return nums[R];
    }
}
