class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.add(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    set.add(i);
                }
            }
        }
        while(!stack.isEmpty()) {
            set.add(stack.pop());
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0 ; i < n ; i++) {
            if (!set.contains(i)) {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}