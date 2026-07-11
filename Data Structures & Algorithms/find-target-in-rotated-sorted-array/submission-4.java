class Solution {
    public int search(int[] nums, int target) {
        int L = 0 , R = nums.length-1;
        
        while(L < R) {
            int mid = L + (R-L)/2;
            int midVal = nums[mid];

            // left ascending 
            if(nums[L] <= midVal) {
                if(target <= midVal && nums[L] <= target) {
                    R = mid;
                } else {
                    L = mid+1;
                }
            }
            // right ascending
            else if(midVal < nums[R]) {
                if(midVal < target && target <= nums[R]) {
                    L = mid+1;
                } else {
                    R = mid;
                }
            }
        }

        if(nums[R] == target) {
            return R;
        } else {
            return -1;
        }
    }
}
