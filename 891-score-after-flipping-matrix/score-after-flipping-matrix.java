class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int res = (1 << (m - 1)) * n;
        for (int j = 1 ; j < m ; j++) {
            int val = (1 << (m - 1 - j));
            int set = 0;
            for (int i = 0 ; i < n ; i++) {
                if (grid[i][j] == grid[i][0]) {
                    set++;
                }
            }
            res += (Math.max(set , n - set)) * val;
        }
        return res;
    }
}

// class Solution {
//     public int matrixScore(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         for (int i = 0; i < n; i++) {
//             if (grid[i][0] == 0) {
//                 for (int j = 0; j < m; j++) {
//                     grid[i][j] = grid[i][j] == 1 ? 0 : 1;
//                 }
//             }
//         }
//         for (int i = 0; i < m; i++) {
//             int count_zero = 0 , count_one = 0;
//             for (int j = 0 ; j < n ; j++) {
//                 if (grid[j][i] == 0) {
//                     count_zero++;
//                 } else {
//                     count_one++;
//                 }
//             }
//             if (count_zero > count_one) {
//                 for (int j = 0; j < n; j++) {
//                     grid[j][i] = grid[j][i] == 1 ? 0 : 1;
//                 }
//             }
//         }
//         // for (int i = 0 ; i < n ; i++) {
//         //     for (int j = 0 ; j < m ; j++) {
//         //         System.out.print(grid[i][j] + " ");
//         //     }
//         //     System.out.println();
//         // }
//         return getScore(grid, n, m);
//     }
//     public int getScore(int[][] arr, int n, int m) {
//         int score = 0;
//         for (int i = 0; i < n; i++) {
//             int num = 0;
//             for (int j = m - 1; j >= 0; j--) {
//                 if (arr[i][j] == 1) {
//                     num += (1 << (m - 1 - j));
//                 }
//             }
//             score += num;
//         }
//         return score;
//     }
// }
