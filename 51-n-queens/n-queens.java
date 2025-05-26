import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0 ; i < n ; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        int[] leftCol = new int[n];
        int[] upperDiagonal = new int[2 * n - 1]; 
        int[] lowerDiagonal = new int[2 * n - 1]; 
        solve(0, board, res, leftCol, upperDiagonal, lowerDiagonal);
        return res;    
    }

    private void solve(int row, char[][] board, List<List<String>> res, 
                       int[] leftCol, int[] upperDiagonal, int[] lowerDiagonal) {
        int n = board.length;

        if (row == n) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (leftCol[col] == 0 && 
                lowerDiagonal[row + col] == 0 && 
                upperDiagonal[n - 1 + row - col] == 0) {

                board[row][col] = 'Q';
                leftCol[col] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + row - col] = 1;

                solve(row + 1, board, res, leftCol, upperDiagonal, lowerDiagonal);

                board[row][col] = '.';
                leftCol[col] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + row - col] = 0;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> temp = new ArrayList<>();
        for (char[] row : board) {
            temp.add(new String(row));
        }
        return temp;
    }
}


// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> result = new ArrayList<>();
//         char board[][] = new char[n][n];

//         for (char row[] : board) {
//             Arrays.fill(row , '.');
//         }
//         solve(0 , board , result , n);
//         return result;
//     }

//     public void solve(int row , char board[][] , List<List<String>> result , int n) {
//         if (row == n) {
//             result.add(construct(board));
//             return;
//         }

//         for (int col = 0 ; col < n ; col++) {
//             if (isSafe(board , row , col , n)) {
//                 board[row][col] = 'Q';
//                 solve(row + 1 , board , result , n);
//                 board[row][col] = '.';
//             }
//         }
//         return;
//     }

//     public boolean isSafe(char board[][] , int row , int col , int n) {
//         for (int i = 0 ; i < row ; i++) {
//             if (board[i][col] == 'Q') {
//                 return false;
//             }
//         }

//         for (int i = row - 1 , j = col - 1 ; i >= 0 && j >= 0 ; i-- , j--) {
//             if (board[i][j] == 'Q') {
//                 return false;
//             }
//         }

//         for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
//             if (board[i][j] == 'Q') return false;
//         }

//         return true;
//     }

//     public List<String> construct(char board[][]) {
//         List<String> temp = new ArrayList<>();
//         for (char row[] : board) {
//             temp.add(new String(row));
//         }
//         return temp;
//     }
// }