class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0 ; i < nums.length-2 ; i++) {
            int j = i+1;
            int k = nums.length-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    String hash = nums[i]+"_"+nums[j]+"_"+nums[k];
                    if(!set.contains(hash)) {
                        set.add(hash);
                        answer.add(List.of(nums[i],nums[j],nums[k]));
                    }
                }
                if(sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return answer;
    }
}
