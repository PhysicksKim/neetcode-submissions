class Solution {
    public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;

        while (L < R) {
            int mid = (L + R) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        if(nums[L] == target) {
            return L;
        } else {
            return -1;
        }
    }
}
