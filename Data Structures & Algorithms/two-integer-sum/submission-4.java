class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0 ; i < nums.length ; i++) {
            int pair = target - nums[i];
            if(map.containsKey(pair) && map.get(pair) != i) {
                return result(i, map.get(pair));
            }
        }

        throw new IllegalStateException();
    }

    private int[] result(int a, int b) {
        if(a < b) {
            return new int[]{a,b};
        } else {
            return new int[]{b,a};
        }
    }
}
