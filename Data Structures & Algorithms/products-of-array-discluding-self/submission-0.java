class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int LEN = nums.length;
        int[] left = new int[LEN];
        int[] right = new int[LEN];
        
        left[0] = nums[0];
        right[LEN-1] = nums[LEN-1];
        for(int i = 1 ; i < LEN ; i++) {
            left[i] = left[i-1]*nums[i];
        }
        for(int i = LEN-2 ; i >= 0 ; i--) {
            right[i] = right[i+1]*nums[i];
        }

        int[] result = new int[LEN];
        result[0] = right[1];
        result[LEN-1] = left[LEN-2];
        for(int i = 1 ; i < LEN-1 ; i++) {
            result[i] = left[i-1]*right[i+1];
        }
        return result;
    }
}  
