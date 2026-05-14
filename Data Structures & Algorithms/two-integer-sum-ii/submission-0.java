class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int L = 0, R = numbers.length-1;
        while(L<R) {
            int sum = numbers[L]+numbers[R];
            if(sum == target) {
                return new int[]{L+1, R+1};
            }
            if(sum > target) {
                R--;
            } else {
                L++;
            }
        }

        throw new IllegalStateException();
    }
}
