class Solution {
    public int longestValidParentheses(String s) {
        // Stack<Integer> stack = new Stack<>();
        // int n = s.length();
        // int maxLen = 0;
        // stack.push(-1);
        // for (int i = 0 ; i < n ; i++) {
        //     char ch = s.charAt(i);
        //     if (ch == '(') {
        //         stack.push(i);
        //     } else {
        //         stack.pop();
        //         if (stack.isEmpty()) {
        //             stack.push(i);
        //         } else {
        //             maxLen = Math.max(maxLen , i - stack.peek());
        //         }
        //     }
        // }
        // return maxLen;

        int left  = 0 , right = 0 , max = 0;
        int n = s.length();
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max , left + right);
            }
            if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = n - 1 ; i >= 0 ; i--) {
            char ch = s.charAt(i);
            if (ch == ')') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max , left + right);
            }
            if (right > left) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }
}