class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(0, 0, s, p, dp);
    }

    public boolean solve(int i, int j, String text, String pattern, Boolean[][] dp) {
        if (j == pattern.length()) {
            return i == text.length();
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean first_match = (i < text.length() &&
                               (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        boolean ans;
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            ans = solve(i, j + 2, text, pattern, dp) || (first_match && solve(i + 1, j, text, pattern, dp));
        } else {
            ans = first_match && solve(i + 1, j + 1, text, pattern, dp);
        }

        return dp[i][j] = ans;
    }
}
