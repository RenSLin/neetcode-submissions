class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            int index2 = s2.charAt(i) - 'a';
            s1Freq[index]++;
            s2Freq[index2]++;
        }

        for (int j = 0; j <= (s2.length()-s1.length()-1); j++) {
            if (Arrays.equals(s1Freq, s2Freq)) return true;
            int index = s2.charAt(j) - 'a';
            int indexNext = s2.charAt(j+s1.length()) - 'a';
            s2Freq[index]--;
            s2Freq[indexNext]++;
        }
        if (Arrays.equals(s1Freq, s2Freq)) return true;
        return false;
    }
}