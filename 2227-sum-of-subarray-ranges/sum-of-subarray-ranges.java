class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int pse[] = new int[n];
        int nse[] = new int[n];
        int pge[] = new int[n];
        int nge[] = new int[n];

        Arrays.fill(nse , n);
        Arrays.fill(nge , n);

        Stack<Integer> stack = new Stack<>();

        // pse (smaller or equivalent)
        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // nse (smaller)
        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();

        // pge (greater or equivalent)
        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // nge (greater)
        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        long maximumSum = 0 , minimumSum = 0;
        for (int i = 0 ; i < n ; i++) {
            maximumSum += (nums[i] * (long)(nge[i] - i) * (long)(i - pge[i]));
            minimumSum += (nums[i] * (long)(nse[i] - i) * (long)(i - pse[i]));
        }       

        return maximumSum - minimumSum;
    }
}