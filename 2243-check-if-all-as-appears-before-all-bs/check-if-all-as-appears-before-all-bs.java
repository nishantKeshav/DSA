class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();
        int last_A_index = -1 ,first_B_index = -1;
        for (int i = n - 1 ; i >= 0 ; i--) {
            char ch = arr[i];
            if (ch == 'a') {
                last_A_index = i;
                break;
            }
        }
        if (last_A_index == -1) {
            return true;
        }
        for (int i = 0 ; i < n ; i++) {
            char ch = arr[i];
            if (ch == 'b') {
                first_B_index = i;
                break;
            }
        }
        if (first_B_index == -1) {
            return true;
        }

        return last_A_index < first_B_index;
    }
}