class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        Deque<Integer> monoS = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!monoS.isEmpty() && heights[monoS.peek()] > heights[i]) {
                int height = heights[monoS.pop()];
                int right = i;
                int left = !monoS.isEmpty() ? monoS.peek() : -1;
                area = Math.max(area, (right - left - 1) * height);
            }
            monoS.push(i);
        }

        while (!monoS.isEmpty()) {
            int height = heights[monoS.pop()];
            int left = !monoS.isEmpty() ? monoS.peek() : -1;
            area = Math.max(area, (heights.length - left - 1) * height);
        }

        return area;
    }
}