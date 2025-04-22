class Solution {
    static long bitCount[];

    public long findMaximumNumber(long k, int x) {
        long low = 0, high = (long) 1e15;
        long ans = 0;
        while (low <= high) {
            long mid = (low + (high - low) / 2);
            bitCount = new long[64];
            Arrays.fill(bitCount, 0);
            getBitsCount(mid);
            long count = 0;
            for (int i = 0; i < 64; i++) {
                if ((i + 1) % x == 0) {
                    count += bitCount[i];
                }
            }
            if (count <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void getBitsCount(long num) {
        if (num == 0) return;
        if (num == 1) {
            bitCount[0]++;
            return;
        }

        int bitLen = getBitLen(num);
        long nearestPowerofTwo = 1L << bitLen;

        bitCount[bitLen] += (num - nearestPowerofTwo + 1);
        for (int i = 0; i < bitLen; i++) {
            bitCount[i] += (nearestPowerofTwo / 2);
        }

        num = num - nearestPowerofTwo;
        if (num >= 0)
            getBitsCount(num);
    }

    private static int getBitLen(long num) {
        int countLength = 0;
        while (num > 1) {
            countLength++;
            num >>= 1;
        }
        return countLength;
    }
}
