class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> yeye = new HashMap<>();

        for (String str : strs) {
            yeye.computeIfAbsent(sortStr(str), k -> new ArrayList<>()).add(str);
        }

        return yeye.values().stream().toList();
    }

    private String sortStr(String str) {
        char[] sArr = str.toCharArray();
        Arrays.sort(sArr);
        return new String(sArr);
    }
}
