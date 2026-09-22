class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> monoS = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!monoS.isEmpty() && temperatures[monoS.peek()] < temperatures[i]) {
                int popIndex = monoS.pop();
                ans[popIndex] = i - popIndex;
            }
            monoS.push(i);
        }
        return ans;
    }
}
