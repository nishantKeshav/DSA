class Solution {
    Map<String, Set<Integer>> memo = new HashMap<>();

    public int scoreOfStudents(String s, int[] answers) {
        Set<Integer> possibleAnswers = solve(s);
        int correctAnswer = getCorrectAnswer(s);        
        int score = 0;
        for (int ans : answers) {
            if (ans == correctAnswer) {
                score += 5;
            } else if (possibleAnswers.contains(ans)) {
                score += 2;
            }
        }
        return score;
    }

    public Set<Integer> solve(String expression) {
        if (memo.containsKey(expression))
            return memo.get(expression);

        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                Set<Integer> leftResults = solve(left);
                Set<Integer> rightResults = solve(right);

                for (int a : leftResults) {
                    for (int b : rightResults) {
                        int val = (ch == '+') ? a + b : a * b;
                        if (val <= 1000) resultSet.add(val);
                    }
                }
            }
        }

        if (resultSet.isEmpty()) {
            if (!expression.contains("+") && !expression.contains("*")) {
                    resultSet.add(Integer.parseInt(expression));
            }
        }


        memo.put(expression, resultSet);
        return resultSet;
    }

    public int getCorrectAnswer(String expr) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (Character.isDigit(ch)) {
                values.push(ch - '0');
            } else if (ch == '+' || ch == '*') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
                    int b = values.pop();
                    int a = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(a, b, op));
                }
                ops.push(ch);
            }
        }

        while (!ops.isEmpty()) {
            int b = values.pop();
            int a = values.pop();
            char op = ops.pop();
            values.push(applyOp(a, b, op));
        }

        return values.pop();
    }

    public int precedence(char op) {
        return (op == '+') ? 1 : 2; 
    }

    public int applyOp(int a, int b, char op) {
        return (op == '+') ? a + b : a * b;
    }
}
