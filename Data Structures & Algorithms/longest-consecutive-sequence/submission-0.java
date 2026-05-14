class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0; 
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> starts = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++) {
            set.add(nums[i]);
            if(!set.contains(nums[i]-1)) {
                starts.add(nums[i]);
                starts.remove(nums[i]+1);
            }
        }

        int maxLen = 0;
        for(int startNum : starts) {
            int len = 1;
            int prev = startNum;
            while(set.contains(prev+1)) {
                len++;
                prev++;
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
