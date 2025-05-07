class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        if (num.length() == 1) {
            if (num.equals("0")) {
                return 0;
            } else {
                return 1;
            }
        }
        if (num.length() == 2) {
            if (num.equals("25") || num.equals("00") || num.equals("75") || num.equals("50")) {
                return 0;
            } else if (num.startsWith("0")) {
                return 1;
            } else if (num.endsWith("0")) {
                return 1;
            }
        }
        int ans = n;
        for (int i = 0 ; i < n ; i++) {
            for (int j = i + 1 ; j < n ; j++) {
                int val = ((num.charAt(i) - '0') * 10) + (num.charAt(j) - '0');
                if (val % 25 == 0) {
                    ans = Math.min(ans , (j - i - 1) + (n - 1 - j));
                }
                if (num.charAt(i) == '0') {
                    ans = Math.min(ans , n - 1);
                }
            }
        }
        return ans;
    }
}
