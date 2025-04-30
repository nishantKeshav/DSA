class Solution {
    public boolean checkValidString(String s) {
        int open = 0 , star = 0;
        int n = s.length();
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else if (ch == '*') {
                star++;
            } else {
                if (open != 0) {
                    open--;
                } else if (star != 0) {
                    star--;
                } else {
                    return false;
                }
            }
        }
        if (star < open) {
            return false;
        }
        // System.out.println(open + " " + star);
        open = 0;
        star = 0;
        for (int i = n - 1 ; i >= 0 ; i--) {
            char ch = s.charAt(i);
            if (ch == ')') {
                open++;
            } else if (ch == '*') {
                star++;
            } else {
                if (open != 0) {
                    open--;
                } else if (star != 0) {
                    star--;
                } else {
                    return false;
                }
            }
        }
        // System.out.println(open + " " + star);
        if (star < open) {
            return false;
        }
        return true;
    }
}