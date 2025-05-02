class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        Arrays.fill(ans , -1);
        for (int i = 0 ; i < 2 * n ; i++) {
            int currIdx = i % n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[currIdx]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = nums[currIdx];
                // beacause the numbers which are eleminated are smaller than the current number will have the NGE as the curr number 
            }
            if (i < n) {
                stack.add(currIdx);
            }
        }
        return ans;

        // // using Indexes - 1st Solution
        // int n = nums.length;
        // int ans[] = new int[n];
        // Stack<Integer> stack = new Stack<Integer>();
        // Arrays.fill(ans , -1);
        // for (int i = 0 ; i < 2 * n ; i++) {
        //     int currIndex = i % n;

        //     while(!stack.isEmpty() && nums[stack.peek()] < nums[currIndex]) {
        //         int prevIndex = stack.pop();
        //         ans[prevIndex] = nums[currIndex];
        //         // beacause the numbers which are eleminated are smaller than the current number will have the NGE as the curr number 
        //     }
        //     if (i < n) {
        //         stack.add(currIndex);
        //     }
        // }
        // return ans;

        // using 2nd Solution using numbers
        // int n = nums.length;
        // int ans[] = new int[n];
        // Stack<Integer> stack = new Stack<Integer>();
        // for (int i = 2 * n - 1 ; i >= 0 ; i--) {
        //     int curr = nums[i % n];
        //     while(!stack.isEmpty() && stack.peek() <= curr) {
        //         stack.pop();
        //     }
        //     if (i < n) {
        //         ans[i] = stack.isEmpty() ? -1 : stack.peek();
        //     }
        //     stack.add(curr);
        // }
        // return ans;
    }
}