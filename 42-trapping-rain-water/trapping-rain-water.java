class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int l = 0 , r = n - 1;
        int leftMax = 0 , rightMax = 0 , ans = 0;

        while(l < r) {
            leftMax = Math.max(arr[l] , leftMax);
            rightMax = Math.max(arr[r] , rightMax);
            
            if (leftMax < rightMax) {
                ans += (leftMax - arr[l]);
                l++;
            } else {
                ans += (rightMax - arr[r]);
                r--;
            }
        }

        return ans;
    }

    // public int trap(int arr[]) {
    //     int n = arr.length;
    //     int leftMax[] = new int[n];
    //     leftMax[0] = arr[0];
    //     for (int i = 1 ; i < n ; i++) {
    //         leftMax[i] = Math.max(leftMax[i-1] , arr[i]);
    //     }
    //     int rightMax[] = new int[n];
    //     rightMax[n - 1] = arr[n - 1];
    //     for (int i = n - 2 ; i >= 0 ; i--) {
    //         rightMax[i] = Math.max(rightMax[i+1] , arr[i]);
    //     }
    //     int ans = 0;
    //     for (int i = 0 ; i < n ; i++) {
    //         ans += (Math.min(rightMax[i] , leftMax[i]) - arr[i]);
    //     }
    //     return ans;
    // }
}