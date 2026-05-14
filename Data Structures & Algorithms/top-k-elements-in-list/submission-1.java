class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] counts = new int[2001];
        for(int e : nums) {
            counts[e+1000]++;
        }

        int[][] arr = new int[2001][2];
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i][0] = counts[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (e1,e2) -> Integer.compare(e2[0],e1[0]));

        int[] answer = new int[k];
        for(int i = 0 ; i < k ; i++) {
            answer[i] = arr[i][1]-1000;
        }
        return answer;
    }
}
