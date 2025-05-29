class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Set<String> row = new HashSet<>();
        // Set<String> col = new HashSet<>();
        // Set<String> grid = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.') {
                    String keyRow = board[i][j] + "-" + i + "row";
                    String keyCol = board[i][j] + "-" + j + "col";
                    String keyGrid = board[i][j] + ":" + (i / 3) + "-" + (j / 3);

                    if (seen.contains(keyRow) || seen.contains(keyCol) || seen.contains(keyGrid)) {
                        System.out.println(keyRow);
                        System.out.println(keyCol);
                        System.out.println(keyGrid);
                        return false;
                    }

                    seen.add(keyRow);
                    seen.add(keyCol);
                    seen.add(keyGrid);
                }
            }
        }
        return true;
    }
}
