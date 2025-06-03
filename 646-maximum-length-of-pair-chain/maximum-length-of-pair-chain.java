class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int prev = pairs[0][1];
        int count = 1;
        for (int i = 1 ; i < pairs.length ; i++) {
            if (pairs[i][0] > prev) {
                count++;
                prev = pairs[i][1];
            }
        }
        return count;
    }
}

// class Solution {
//     Integer[][] dp;
//     int OFFSET;
//     int MAX;
//     public int findLongestChain(int[][] pairs) {
//         int n = pairs.length;
//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
//         for (int[] pair : pairs) {
//             min = Math.min(min, pair[0]);
//             max = Math.max(max, pair[1]);
//         }
//         OFFSET = -min;
//         MAX = max + OFFSET + 1;
//         dp = new Integer[n][MAX + 1];
//         return solve(0, pairs, n, Integer.MIN_VALUE);
//     }

//     public int solve(int idx, int[][] pairs, int n, int prevLast) {
//         if (idx >= n) {
//             return 0;
//         }
//         int offsetIndex = (prevLast == Integer.MIN_VALUE) ? 0 : prevLast + OFFSET;
//         if (dp[idx][offsetIndex] != null) {
//             return dp[idx][offsetIndex];
//         }
//         int take = Integer.MIN_VALUE;
//         if (idx == 0) {
//             take = 1 + solve(idx + 1, pairs, n, pairs[idx][1]);
//         } else {
//             if (prevLast < pairs[idx][0]) {
//                 take = 1 + solve(idx + 1, pairs, n, pairs[idx][1]);
//             }
//         }
//         int not_take = solve(idx + 1, pairs, n, prevLast);
//         return dp[idx][offsetIndex] = Math.max(take, not_take);
//     }
// }
