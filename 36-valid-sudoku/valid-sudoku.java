class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> row = new HashSet<>();
        Set<String> col = new HashSet<>();
        Set<String> grid = new HashSet<>();

        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.') {
                    String keyRow = board[i][j] + "-" + i;
                    String keyCol = board[i][j] + "-" + j;
                    String keyGrid = board[i][j] + "-" + (i / 3) + "-" + (j / 3);

                    if (row.contains(keyRow) || col.contains(keyCol) || grid.contains(keyGrid)) {
                        return false;
                    }

                    row.add(keyRow);
                    col.add(keyCol);
                    grid.add(keyGrid);
                }
            }
        }
        return true;
    }
}
