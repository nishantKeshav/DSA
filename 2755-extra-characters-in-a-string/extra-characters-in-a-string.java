class Solution {

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> set = new HashSet<String>();
        for (String str : dictionary) {
            set.add(str);
        }
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, dp, set, s);
    }

    public int solve(int idx, int n, int dp[], HashSet<String> set, String str) {
        if (idx >= n) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }
        int result = n;
        for (int j = idx + 1; j <= n; j++) {
            String curr = str.substring(idx, j);
            int currExtra = set.contains(curr) ? 0 : curr.length();
            int nextExtra = solve(j, n, dp, set, str);
            int totalExtra = nextExtra + currExtra;
            result = Math.min(result, totalExtra);
        }

        return dp[idx] = result;
    }
}
