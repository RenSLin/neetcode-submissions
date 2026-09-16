class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tFreq.put(t.charAt(i), tFreq.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int required = tFreq.size();
        int formed = 0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sFreq.put(c, sFreq.getOrDefault(c, 0) + 1);
            if (tFreq.containsKey(c) && sFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }
            while (formed == required) {
                if ((right - left + 1) < resLen) {
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }
                char leftChar = s.charAt(left);
                sFreq.put(leftChar, sFreq.get(leftChar) - 1);
                if (tFreq.containsKey(leftChar) && sFreq.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" 
        : s.substring(res[0], res[1] + 1);
    }
}
