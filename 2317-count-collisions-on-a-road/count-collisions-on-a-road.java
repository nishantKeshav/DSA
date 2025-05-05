class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < n ; i++) {
            char ch = directions.charAt(i);
            if (!stack.isEmpty() && ch == 'L' && stack.peek() != 'L') {
                count++;
                char prev = stack.pop();
                if (prev == 'R') {
                    count++;
                }
                while(!stack.isEmpty() && stack.peek() == 'R') {
                    count++;
                    stack.pop();
                }
                stack.push('S');
            } else if (!stack.isEmpty() && ch == 'S' && stack.peek() == 'R') {
                while(!stack.isEmpty() && stack.peek() == 'R') {
                    count++;
                    stack.pop();
                }
                stack.push('S');
            } else {
                stack.push(ch);
            }
        }

        return count;
    }
}