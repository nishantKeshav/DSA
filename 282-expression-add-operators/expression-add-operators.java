class Solution {

    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        solve(list, new StringBuilder(), num, target, 0, 0, 0);
        return list;
    }

    public void solve(List<String> list, StringBuilder ans, String num, int target, int idx, long evaluated, long prev) {
        if (idx == num.length()) {
            if (evaluated == target) {
                list.add(ans.toString());
            }
            return;
        }

        long currNum = 0;
        for (int i = idx; i < num.length(); i++) {
            if (i > idx && num.charAt(idx) == '0') {
                break;
            }

            currNum = currNum * 10 + (num.charAt(i) - '0');

            int len = ans.length();

            if (idx == 0) {
                ans.append(currNum);
                solve(list, ans, num, target, i + 1, currNum, currNum);
                ans.setLength(len);
            } else {
                ans.append("+").append(currNum);
                solve(list, ans, num, target, i + 1, evaluated + currNum, currNum);
                ans.setLength(len);

                ans.append("-").append(currNum);
                solve(list, ans, num, target, i + 1, evaluated - currNum, -currNum);
                ans.setLength(len);

                ans.append("*").append(currNum);
                solve(list, ans, num, target, i + 1, evaluated - prev + prev * currNum, prev * currNum);
                ans.setLength(len);
            }
        }
    }
}
