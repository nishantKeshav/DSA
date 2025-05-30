class Solution {
    public String minimizeResult(String expression) {
        String parts[] = expression.split("\\+");
        String left = parts[0];
        String right = parts[1];

        int min = Integer.MAX_VALUE;
        String result = "(" + expression + ")";

        for (int i = 0 ; i < left.length() ; i++) {
            int leftMul = left.substring(0 , i).equals("") ? 1 : Integer.parseInt(left.substring(0 , i));
            int leftNum = Integer.parseInt(left.substring(i));

            for (int j = 1 ; j <= right.length() ; j++) {
                int rightMul = right.substring(j).equals("") ? 1 : Integer.parseInt(right.substring(j));
                int rightNum = Integer.parseInt(right.substring(0 , j));

                int totalSum = leftMul * (leftNum + rightNum) * rightMul;
                if (totalSum < min) {
                    min = totalSum;
                    result = left.substring(0 , i) + "(" + left.substring(i) + "+" + right.substring(0 , j) + ")" + right.substring(j); 
                }
            }
        }
        return result;
    }
}