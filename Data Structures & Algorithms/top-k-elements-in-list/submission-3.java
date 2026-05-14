class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] listArr = new List[nums.length+1];

        for(var entry : map.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();

            List<Integer> list = listArr[freq];
            if(list == null) {
                list = new ArrayList<>();
                listArr[freq] = list;
            }
            list.add(num);
        }

        int idx = 0;
        int[] answer = new int[k];
        for(int i = listArr.length-1 ; i >= 0 && idx < k ; i--) {
            List<Integer> nowList = listArr[i];
            if(nowList == null) continue;
            
            for(int a = 0 ; a < nowList.size() && idx < k ; a++, idx++) {
                answer[idx] = nowList.get(a);
            }
        }

        return answer;
    }
}
