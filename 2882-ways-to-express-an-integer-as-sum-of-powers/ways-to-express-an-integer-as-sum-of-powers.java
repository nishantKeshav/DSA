class Solution {
    public int numberOfWays(int n, int x) {
        int arr[] = new int[301];
        arr[0] = 1;
        int mod = (int)(1e9 + 7);
        int v = -1;
        for (int sum = 1 ; (v = (int)(Math.pow(sum , x))) <= n ; sum++) {
            for(int i = n ; i >= v ; i--) {
                arr[i] = (arr[i] + arr[i - v]) % mod;
            }
        }
        return arr[n];
    }
}


// class Solution {
//     int mod = (int) (1e9 + 7);

//     public int numberOfWays(int n, int x) {
//         Integer dp[][] = new Integer[n + 2][n + 2];
//         return solve(1, n, x, 0 , dp);
//     }

//     public int solve(int num, int n, int x, int currSum , Integer dp[][]) {
//         if (currSum > n) {
//             return 0;
//         }

//         if (currSum == n) {
//             return 1;
//         }

//         if (dp[num][currSum] != null) {
//             return dp[num][currSum];
//         }

//         int count = 0;
//         currSum %= mod;
//         int include = 0;
//         int notInclude = 0;
//         int power = (int) Math.pow(num, x);
//         if (currSum + power <= n) {
//             include = solve(num + 1, n, x, currSum + power , dp) % mod;
//         }

//         if (currSum + power <= n) {
//             notInclude = solve(num + 1, n, x, currSum , dp) % mod;
//         }

//         count += ((include + notInclude) % mod);

//         return dp[num][currSum] = (count % mod);
//     }
// }
