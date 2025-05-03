class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int rotations = Integer.MAX_VALUE;
        for (int num = 1 ; num <= 6 ; num++) {
            int ops = findRotations(tops , bottoms , n , num);
            if (ops != -1) {
                rotations = Math.min(rotations , ops);
            }
        }
        return rotations == Integer.MAX_VALUE ? -1 : rotations;
    }

    public int findRotations(int arr1[] , int arr2[] , int n , int num) {
        int topRotations = 0 , bottomRotations = 0;
        for (int i = 0 ; i < n ; i++) {
            if (arr1[i] != num && arr2[i] != num) {
                return -1;
            } else if (arr1[i] == num && arr2[i] == num) {
                continue;
            } else if (arr1[i] == num) {
                bottomRotations++;
            } else if (arr2[i] == num) {
                topRotations++;
            }
        }
        // System.out.println(num + " " + topRotations + " " + bottomRotations);
        return Math.min(topRotations , bottomRotations);
    }
}