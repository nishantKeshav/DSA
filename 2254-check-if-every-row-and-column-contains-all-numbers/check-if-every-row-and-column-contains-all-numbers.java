class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int sum = (n * (n + 1)) / 2;
        return solve(matrix , 0 , n , true , sum) && solve(matrix , 0 , n , false , sum);
    }

    public boolean solve(int arr[][] , int row , int n , boolean cond , int sum) {
        if (row == n) {
            return true;
        }
        int currSum = 0;
        if (cond) {
            int currNum = arr[row][0];
            currSum = currNum;
            for (int i = 1 ; i < n ; i++) {
                if (currNum == arr[row][i]) {
                    return false;
                }
                currSum += arr[row][i];
            }
        } else {
            for (int i = 0 ; i < n ; i++) {
                currSum += arr[i][row];
            }
        }
        if (currSum != sum) {
            return false;
        }
        return solve(arr , row + 1 , n , cond , sum);
    }
}