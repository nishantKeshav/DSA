class Solution {
    public int totalStrength(int[] nums) {
        
        int n = nums.length;
        int mod = (int)(Math.pow(10 , 9) + 7);

        long[] prefixsum = new long[n + 1];
        long[] prefixPrefixsum = new long[n + 2];
        for(int i = 0; i < n; i++){
            prefixsum[i + 1] = (prefixsum[i] + nums[i]) % mod;
            prefixPrefixsum[i + 2] = (prefixPrefixsum[i + 1] + prefixsum[i + 1]) % mod;
        }
        
        Stack<Integer> stack = new Stack<>();
        int nse[] = new int[n];
        int pse[] = new int[n];
        
        // Used for previous smaller element (smaller or equal)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Used for next smaller element (strictly smaller)
        for (int i = n - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long total = 0;

        for (int i = 0 ; i < n ; i++) {
            
            int left = pse[i];
            int right = nse[i];

            long leftSum = (prefixPrefixsum[i + 1] - prefixPrefixsum[left + 1] + mod) % mod;
            long rightSum = (prefixPrefixsum[right + 1] - prefixPrefixsum[i + 1] + mod) % mod;

            long contrib = (nums[i] * ((rightSum * (i - left) % mod) - (leftSum * (right - i) % mod) + mod)) % mod;
            total = ((total + contrib) % mod);
        }

        return (int)total;
    }
}