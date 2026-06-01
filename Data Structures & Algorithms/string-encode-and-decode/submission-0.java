class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for (String word : strs) {
            int len = word.length();
            encodedString.append(String.valueOf(len) + "#" + word);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();
        int index = 0;

        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                int hashIndex = str.indexOf('#', index);
                int wordLength = Integer.parseInt(str.substring(index, hashIndex));
                String word = str.substring(hashIndex + 1, hashIndex + 1 + wordLength);
                decodedString.add(word);
                index = hashIndex + wordLength + 1;
            } 
        }

        return decodedString;
    }
}
