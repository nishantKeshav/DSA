class Solution {
    public int[] dailyTemperatures(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        
        int ans[] = new int[n];

        for (int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int prevIdx = stack.pop();
                ans[prevIdx] = i - prevIdx;;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }

        return ans;
    }
}