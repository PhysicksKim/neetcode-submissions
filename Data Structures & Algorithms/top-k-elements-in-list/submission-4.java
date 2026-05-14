class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        int[] res = new int[k];

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int i =0;
        for(Map.Entry<Integer, Integer> e : pq) {
            res[i] = e.getKey();
            i++;
        }
        return res;
    }
}
