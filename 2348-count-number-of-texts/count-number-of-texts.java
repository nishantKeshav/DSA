class Solution {
    int mod = (int) (Math.pow(10, 9) + 7);

    public int countTexts(String pressedKeys) {
        int key[] = new int[] { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
        int n = pressedKeys.length();
        Long dp[] = new Long[n + 1];
        return solve(0, pressedKeys, key , dp);
    }

    public int solve(int idx, String s, int key[] , Long dp[]) {
        if (idx == s.length()) {
            return 1;
        }

        if (dp[idx] != null) {
            return (int)(dp[idx] % mod); 
        }
        long count = 0;
        int num = s.charAt(idx) - '0';
        int rey = key[num];
        for (int i = 0; i < rey && idx + i < s.length() && s.charAt(idx) == s.charAt(idx + i); i++) {
            count += solve(idx + 1 + i, s, key , dp);
            count %= mod;
        }
        dp[idx] = count % mod;
        return (int)count;
    }
}
