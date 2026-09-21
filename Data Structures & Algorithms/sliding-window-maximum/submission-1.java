class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> monoS = new ArrayDeque<>();

        //monotonic stack for ordering i think
        for (int i = 0; i < k; i++) {
            while (!monoS.isEmpty() && nums[monoS.peekLast()] < nums[i]) {
                monoS.pollLast();
            }
            monoS.addLast(i);
        }
        ans[0] = nums[monoS.getFirst()];
        for (int j = k; j < nums.length; j++) {
            //is the max outside the range
            if (monoS.peekFirst() <= j-k) {
                monoS.pollFirst();
            }
            while (!monoS.isEmpty() && nums[monoS.peekLast()] < nums[j]) {
                monoS.pollLast();
            }
            monoS.addLast(j);
            ans[j-k+1] = nums[monoS.getFirst()];
        }
        return ans;
    }
}
