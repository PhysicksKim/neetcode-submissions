class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for(int x = 0 ; x < nums.length ; x++) {
            arr[x][0] = nums[x];
            arr[x][1] = x;
        }
        Arrays.sort(arr, (e1,e2) -> Integer.compare(e1[0],e2[0]));

        int p1 = 0, p2 = arr.length-1;
        while(p1 < p2) {
            int sum = arr[p1][0] + arr[p2][0];
            if(sum == target) {
                int idx1 = arr[p1][1];
                int idx2 = arr[p2][1];
                if(idx1 > idx2) {
                    int temp = idx1;
                    idx1 = idx2;
                    idx2 = temp;
                }
                return new int[]{idx1,idx2};
            }
            if(sum < target) {
                p1++;
            } else {
                p2--;
            }
        }

        throw new IllegalStateException("Only one valid answer exists");
    }
}
