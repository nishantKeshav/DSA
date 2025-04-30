class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Stack<Integer> open = new Stack<Integer>();
        Stack<Integer> openClose = new Stack<Integer>();
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            char locked_ch = locked.charAt(i);
            if (locked_ch == '0') {
                openClose.push(i);
            } else if (ch == '(') {
                open.push(i);
            } else if (ch == ')') {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!openClose.isEmpty()) {
                    openClose.pop();
                } else {
                    return false;
                }
            }
        }
        while(!open.isEmpty() && !openClose.empty() && open.peek() < openClose.peek()) {
            open.pop();
            openClose.pop();
        }
        return open.isEmpty();
    }
}