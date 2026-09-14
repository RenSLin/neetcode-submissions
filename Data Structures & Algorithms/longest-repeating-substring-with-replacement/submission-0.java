class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int left = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int right = 0; right < s.length(); right++) {
            //windowSize - maxFreq <= k is valid
            int index = s.charAt(right) - 'A';
            freq[index]++;
            maxFreq = Math.max(maxFreq, freq[index]);
            if (right - left + 1 - maxFreq <= k) {
                max = Math.max(max, right - left + 1);
            } else {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return max;
    }
}
