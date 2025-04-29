class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'b') {
                stack.push(ch);
                // System.out.println(stack);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char tempCh = stack.pop();
                // System.out.println(tempCh);
                if (tempCh != 'b') {
                    return false;
                }
                if (stack.isEmpty()) {
                    return false;
                }
                // System.out.println(stack);
                tempCh = stack.pop();
                // System.out.println(tempCh);
                if (tempCh != 'a') {
                    return false;
                }
                // System.out.println(stack);
            }
        }
        return stack.isEmpty();
    }
}