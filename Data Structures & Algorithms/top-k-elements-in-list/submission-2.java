class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            Integer g = map.get(nums[i]);
            if(g == null) {
                map.put(nums[i],1);
            } else {
                map.put(nums[i],g+1);
            }
        }

        int[][] arr = new int[map.size()][2];
        int idx = 0;
        for(var entry : map.entrySet()) {
            arr[idx][0] = entry.getValue();
            arr[idx][1] = entry.getKey();
            idx++;
        }

        Arrays.sort(arr, (e1,e2)->Integer.compare(e2[0],e1[0]));

        int[] answer = new int[k];
        for(int i = 0 ; i < k ; i++) {
            answer[i] = arr[i][1];
        }
        return answer;
    }
}
