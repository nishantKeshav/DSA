class Solution {
    
    int directions[][] = {{0 , 1} , {1 , 0} , {-1 , 0} , {0 , -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (board[i][j] == word.charAt(0) && solve(board , i , j , word , len , 0 , n , m)) {
                    return true;
                }
            }
        }
        return false;    
    }

    public boolean solve(char board[][] , int i , int j , String word , int len , int idx , int n , int m) {
        if (idx == len) {
            return true;
        }

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for (int dir[] : directions) {
            if (solve(board , i + dir[0] , j + dir[1] , word , len , idx + 1 , n , m)) {
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}