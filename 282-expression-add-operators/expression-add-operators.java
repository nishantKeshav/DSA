class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        solve(list, 0, 0, 0, num, target, new StringBuilder());
        return list;
    }

    public void solve(List<String> list, int idx, long currSum, long prevNum, String num, int target, StringBuilder str) {
        if (idx == num.length()) {
            if (currSum == target) {
                list.add(str.toString());
            }
            return;
        }

        for (int i = idx; i < num.length(); i++) {
            if (i != idx && num.charAt(idx) == '0') break; // prevent leading zero

            String currStr = num.substring(idx, i + 1);
            long currNum = Long.parseLong(currStr);
            int len = str.length();

            if (idx == 0) {
                // First number, so no operator
                str.append(currStr);
                solve(list, i + 1, currNum, currNum, num, target, str);
                str.setLength(len); // backtrack
            } else {
                // '+'
                str.append("+").append(currStr);
                solve(list, i + 1, currSum + currNum, currNum, num, target, str);
                str.setLength(len);

                // '-'
                str.append("-").append(currStr);
                solve(list, i + 1, currSum - currNum, -currNum, num, target, str);
                str.setLength(len);

                // '*'
                str.append("*").append(currStr);
                solve(list, i + 1, currSum - prevNum + prevNum * currNum, prevNum * currNum, num, target, str);
                str.setLength(len);
            }
        }
    }
}
