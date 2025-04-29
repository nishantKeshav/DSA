class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int count = 0 , max_count = 0 , num = 1;
        int n = arr.length;
        for (int i = 0 ; i < n - 1 ; i++) {
            if (num == 1) {
                if (arr[i] > arr[i+1]) {
                    count++;
                    num = 2;
                } else {
                    max_count = Math.max(max_count , count);
                    count = 0;
                    num = 1;
                    if (arr[i] < arr[i+1]) {
                        count++;
                    }
                }
            } else if (num == 2) {
                if (arr[i] < arr[i + 1]) {
                    count++;
                    num = 1;
                } else {
                    max_count = Math.max(max_count , count);
                    count = 0;
                    num = 2;
                    if (arr[i] > arr[i+1]) {
                        count++;
                    }
                }
            }
        }
        max_count = Math.max(max_count , count);
        return max_count + 1;
    }
}