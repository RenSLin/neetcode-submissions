class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map <Character, Integer> freq = new HashMap<>();

        for (char word : s.toCharArray()) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (char ye : t.toCharArray()) {
            if (!freq.containsKey(ye) || freq.get(ye) == 0) {
                return false;
            }
            freq.put(ye, freq.get(ye) - 1);
        }
        return true;
    }
}
