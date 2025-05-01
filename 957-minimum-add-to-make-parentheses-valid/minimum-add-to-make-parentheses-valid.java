class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int open_count = 0 , close_count = 0;
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open_count++;
            } else {
                if (open_count > 0) {
                    open_count--;
                } else {
                    close_count++;
                }
            }
        }
        return open_count + close_count;
    }
}