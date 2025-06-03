class Solution {
    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        reverse(cookies); 
        
        int low = cookies[0], high = Arrays.stream(cookies).sum();
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] children = new int[k];
            if (canDistribute(0, cookies, children, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }

    private boolean canDistribute(int idx, int[] cookies, int[] children, int limit) {
        if (idx == cookies.length) return true;

        for (int i = 0; i < children.length; i++) {
            if (children[i] + cookies[idx] <= limit) {
                children[i] += cookies[idx];
                if (canDistribute(idx + 1, cookies, children, limit)) return true;
                children[i] -= cookies[idx];
            }
            if (children[i] == 0) break;
        }
        return false;
    }

    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
