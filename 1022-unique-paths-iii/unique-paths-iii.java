class Solution {
    int directions[][] = {{0 , 1} , {0 , -1} , {1 , 0} , {-1 , 0}};
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int emptyCells = 0;
        int start_row = -1 , start_col = -1;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (grid[i][j] == 1) {
                    start_row = i;
                    start_col = j;
                }
                if (grid[i][j] == 1 || grid[i][j] == 0 || grid[i][j] == 2) {
                    emptyCells += 1;
                }
            }
        }
        return solve(start_row , start_col , m , n , grid, emptyCells);
    }

    public int solve(int i , int j , int m , int n , int grid[][] , int emptyCells) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return 0;
        }

        if (grid[i][j] == 2) {
            if (emptyCells == 1) {
                return 1;
            } else {
                return 0;
            }
        }

        int temp = grid[i][j];
        grid[i][j] = -1;

        int count = 0;
        for (int arr[] : directions) {
            count += solve(i + arr[0] , j + arr[1] , m , n , grid , emptyCells - 1 );
        }

        grid[i][j] = temp;

        return count;
    }
}