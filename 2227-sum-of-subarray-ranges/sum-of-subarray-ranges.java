class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int pse[] = new int[n];
        int nse[] = new int[n];
        int pge[] = new int[n];
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Used for previous smaller element (smaller or equal)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();

        // Used for next smaller element (strictly smaller)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();

        // Used for previous greater element (greater or equal)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) { 
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();

        // Used for next greater element (strictly greater)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long maximumSum = 0, minimumSum = 0;
        for (int i = 0; i < n; i++) {
            maximumSum += (nums[i] * (long)(nge[i] - i) * (long)(i - pge[i]));
            minimumSum += (nums[i] * (long)(nse[i] - i) * (long)(i - pse[i]));
        }

        return maximumSum - minimumSum;
    }
}
