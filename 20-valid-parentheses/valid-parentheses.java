class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char tempCh = stack.peek();
                if (ch == ']' && tempCh != '[') {
                    return false;
                }
                if (ch == ')' && tempCh != '(') {
                    return false;
                }
                if (ch == '}' && tempCh != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}