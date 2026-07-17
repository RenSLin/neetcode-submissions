class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> arithmetic = Set.of("+", "-", "*", "/");
        Deque<String> nums = new ArrayDeque<>();

        for(int i = 0; i < tokens.length; i++) {
            if (!arithmetic.contains(tokens[i])) {
                nums.push(tokens[i]);
            } else {
                int num1 = Integer.parseInt(nums.pop());
                int num2 = Integer.parseInt(nums.pop());
                int result = 0;
                switch(tokens[i]) {
                    case "+" -> result += num1+num2;
                    case "-" -> result += num2-num1;
                    case "*" -> result += num1*num2;
                    case "/" -> result += num2/num1;
                }
                nums.push(String.valueOf(result));
            }
        }

        return Integer.parseInt(nums.pop());
    }
}
