class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Pair> map = new HashMap<>();
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < cols ; j++) {
                map.put(mat[i][j], new Pair(i, j));
            }
        }

        int[] rowPaint = new int[rows];
        int[] colPaint = new int[cols];

        for (int i = 0 ; i < arr.length ; i++) {
            Pair p = map.get(arr[i]);
            rowPaint[p.row]++;
            colPaint[p.col]++;

            if (rowPaint[p.row] == cols || colPaint[p.col] == rows) {
                return i;
            }
        }
        return -1;
    }

    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
