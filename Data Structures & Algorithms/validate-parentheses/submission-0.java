class Solution {
    public boolean isValid(String s) {    
        Deque<Character> checkStack = new ArrayDeque<>();
        Set<Character> leftP = new HashSet<>(Arrays.asList('{', '(', '['));
        for (char p : s.toCharArray()) {
            if (leftP.contains(p)) {
                checkStack.push(p);
            } else {
                if (checkStack.isEmpty()) return false;
                char rightP = checkStack.pop();
                if ((p == '}' && rightP != '{') ||
                    (p == ')' && rightP != '(') ||
                    (p == ']' && rightP != '[')) {
                        return false;
                    }
            }
        }
        return checkStack.isEmpty(); 
    }
}
