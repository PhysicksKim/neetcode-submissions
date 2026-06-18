class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int LEN = matrix.length * matrix[0].length;
        int L = 0, R = LEN-1;
        
        while(L<R) {
            int mid = L+(R-L)/2; // == (L+R)/2

            int I = mid / matrix[0].length;
            int J = mid % matrix[0].length;
            int now = matrix[I][J];

            if(target <= now) {
                R = mid;
            } else {
                L = mid+1;
            }
        }

        int I = L / matrix[0].length;
        int J = L % matrix[0].length;
        return matrix[I][J] == target;
    }
}
