class Solution {
    public boolean asteroidsDestroyed(int mass, int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long m = mass;
        for (int i = 0 ; i < n ; i++) {
            if (m >= arr[i]) {
                m += arr[i];
            } else {
                return false;
            }
        }
        return true;
    }
}