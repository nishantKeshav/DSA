class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }
        int freq[] = new int[32];
        freq[0] = 1;
        for (int i = 1 ; i < 32 ; i++) {
            freq[i] = (2 * freq[i-1]) + 1;
        }
        int ans = 0;
        int sign = 1;
        for (int i = 30 ; i >= 0 ; i--) {
            boolean ithBit = ((n >> i) & 1) > 0;
            if (ithBit) {
                if (sign > 0) {
                    ans += freq[i];
                } else {
                    ans -= freq[i];
                }
                sign = (sign == 1) ? -1 : 1;;
            }
        }
        return ans;
    }
}