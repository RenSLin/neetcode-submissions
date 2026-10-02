class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rLeft = 0;
        int rRight = matrix.length - 1;
        int cLeft = 0;
        int cRight = matrix[0].length - 1;
        int rIndex = 0;

        while (rLeft <= rRight) {
            rIndex = rLeft + (rRight - rLeft)/2;
            if (matrix[rIndex][0] > target) {
                rRight = rIndex - 1;
            }
            if (matrix[rIndex][0] < target) {
                rLeft = rIndex + 1;
            }
            if (target >= matrix[rIndex][0] && target <= matrix[rIndex][cRight]) {
                break;
            }
        }

        while (cLeft <= cRight) {
            int mid = cLeft + (cRight - cLeft)/2;
            if (matrix[rIndex][mid] == target) {
                return true;
            }
            if (matrix[rIndex][mid] < target) {
                cLeft = mid + 1;
            }
            if (matrix[rIndex][mid] > target) {
                cRight = mid - 1;
            }
        }
        return false;
    }
}
