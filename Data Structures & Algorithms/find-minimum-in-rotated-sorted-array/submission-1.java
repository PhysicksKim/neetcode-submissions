class Solution {
    public int findMin(int[] nums) {
        final int LEN = nums.length;

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
