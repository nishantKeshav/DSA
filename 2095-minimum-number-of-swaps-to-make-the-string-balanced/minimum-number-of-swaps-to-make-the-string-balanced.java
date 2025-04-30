class Solution {
    public int minSwaps(String s) {
        int open_count = 0 , close_count = 0;
        int n = s.length();
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                open_count++;
            } else {
                if (open_count > 0) {
                    open_count--;
                } else {
                    close_count++;
                }
            }
        }
        return (close_count + 1) / 2;
    }
}