class Solution {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return solve(0, 0, s, p);
    }

    private boolean solve(int i, int j, String s, String p) {
        
        if (j == p.length()) {
            return memo[i][j] = (i == s.length());
        }

        if (memo[i][j] != null) return memo[i][j];

        boolean match = (i < s.length() &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'));

        if (p.charAt(j) == '*') {
            boolean matchStar = (solve(i, j + 1, s, p) || (i < s.length() && solve(i + 1, j, s, p)));
            return memo[i][j] = matchStar;
        } else {
            return memo[i][j] = match && solve(i + 1, j + 1, s, p);
        }
    }
}
