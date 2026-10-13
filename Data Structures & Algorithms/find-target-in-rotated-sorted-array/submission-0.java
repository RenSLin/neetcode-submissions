class Solution {
    public int search(int[] nums, int target) {

        int rotatePoint = findMin(nums);
        int lSol = binarySearch(nums, target, 0, rotatePoint);
        int rSol = binarySearch(nums, target, rotatePoint, nums.length -1);
        return Math.max(lSol, rSol);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
