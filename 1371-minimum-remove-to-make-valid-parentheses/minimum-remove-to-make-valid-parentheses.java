class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        int openCount = 0 , closeCount = 0;
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openCount++;
            } else if (ch == ')') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    closeCount++;
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == ')' && closeCount > 0) {
                closeCount--;
                continue;
            }
            str.append(ch);
        }
        s = str.toString();
        n = s.length();
        str.setLength(0);
        for (int i = n - 1 ; i >= 0 ; i--) {
            char ch = s.charAt(i);
            if (ch == '(' && openCount > 0) {
                openCount--;
                continue;
            }
            str.append(ch);
        }
        return str.reverse().toString();
    }
}

// class Solution {
//     public String minRemoveToMakeValid(String s) {
//         int n = s.length();
//         Stack<Integer> stack = new Stack<>();
//         HashSet<Integer> set = new HashSet<>();
//         for (int i = 0 ; i < n ; i++) {
//             char ch = s.charAt(i);
//             if (ch == '(') {
//                 stack.add(i);
//             } else if (ch == ')') {
//                 if (!stack.isEmpty()) {
//                     stack.pop();
//                 } else {
//                     set.add(i);
//                 }
//             }
//         }
//         while(!stack.isEmpty()) {
//             set.add(stack.pop());
//         }
//         StringBuilder str = new StringBuilder();
//         for (int i = 0 ; i < n ; i++) {
//             if (!set.contains(i)) {
//                 str.append(s.charAt(i));
//             }
//         }
//         return str.toString;
//     }
// }