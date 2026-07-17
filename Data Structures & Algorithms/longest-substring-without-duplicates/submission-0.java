class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (lastSeen.containsKey(s.charAt(i))) {
                if (lastSeen.get(s.charAt(i)) >= left) {
                    left = lastSeen.get(s.charAt(i)) + 1;
                }
            }
            lastSeen.put(s.charAt(i), i);
            max = Math.max(max, i - left +1);
        }

        return max;
    }
}
