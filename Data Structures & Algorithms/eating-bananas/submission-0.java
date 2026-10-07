class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) right = Math.max(right, pile);

        while (left < right) {
            int mid = left + (right-left)/2;
            long totalTime = 0L;
            for (int pile : piles) {
                totalTime += (pile + mid - 1) / mid;
            }
            if (totalTime > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
