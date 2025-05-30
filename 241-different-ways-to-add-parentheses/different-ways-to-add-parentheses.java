class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                String str1 = expression.substring(0, i);
                String str2 = expression.substring(i + 1);
                List<Integer> part1 = diffWaysToCompute(str1);
                List<Integer> part2 = diffWaysToCompute(str2);
                for (Integer num1 : part1) {
                    for (Integer num2 : part2) {
                        int num = 0;
                        switch (ch) {
                            case '+':
                                num = num1 + num2;
                                break;
                            case '-':
                                num = num1 - num2;
                                break;
                            case '*':
                                num = num1 * num2;
                                break;
                        }
                        res.add(num);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}
