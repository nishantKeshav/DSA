class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        long mod = (long)(1e9 + 7);
        long xorA = 0 , xorB = 0;
        for (int i = 49 ; i >= n ; i--) {
            boolean aSet = ((a >> i) & 1) > 0;
            boolean bSet = ((b >> i) & 1) > 0;
            if (aSet) {
                xorA ^= (1L << i);
            }
            if (bSet) {
                xorB ^= (1L << i);
            }
        }
        for (int i = n - 1 ; i >= 0 ; i--) {
            boolean aSet = ((a >> i) & 1) > 0;
            boolean bSet = ((b >> i) & 1) > 0;
            if (aSet == bSet) {
                xorA ^= (1L << i);
                xorB ^= (1L << i);
            } else if (xorA > xorB) {
                xorB ^= (1L << i);
            } else {
                xorA ^= (1L << i);
            }
        }
        xorA %= mod;
        xorB %= mod;
        return (int)((xorA * xorB) % mod);
    }
}