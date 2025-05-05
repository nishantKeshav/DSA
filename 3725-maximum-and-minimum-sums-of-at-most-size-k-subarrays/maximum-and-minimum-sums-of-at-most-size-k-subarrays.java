class Solution {
    public long minMaxSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        int nge[] = new int[n];
        int pge[] = new int[n];

        Arrays.fill(nse , n);
        Arrays.fill(pse , -1);
        Arrays.fill(nge , n);
        Arrays.fill(pge , -1);

        Stack<Integer> stack = new Stack<>();

        // pse (smaller or equal) 
        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // nse (strictly Smaller)
        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        
        // pge (greater or equal)
        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // nge (strictly greater)
        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        long res = 0;

        for (int i = 0 ; i < n ; i++) {
            int leftMin = Math.min(i - pse[i] , k);
            int rightMin = Math.min(nse[i] - i , k);

            res += (long)(nums[i] * lessthanK(leftMin , rightMin , k));

            int leftMax = Math.min(i - pge[i] , k);
            int rightMax = Math.min(nge[i] - i , k);

            res += (long)(nums[i] * lessthanK(leftMax , rightMax , k));
        }

        return res;
    }

    public long lessthanK(int left , int right , int k) {
        int len = Math.max(0 , left + right - 1);
        if (len <= k) {
            return 1L * left * right;
        }
        int extra = Math.max(0, left + right - 1 - k);
        long sub = (long) extra * (extra + 1) / 2;
        return 1L * left * right - sub;
    }
}