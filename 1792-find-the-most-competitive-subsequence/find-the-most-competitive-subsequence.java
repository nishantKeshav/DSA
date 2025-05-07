class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < n ; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() + (n - i - 1) >= k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        System.out.println(stack);
        int idx = 0;
        int ans[] = new int[k];
        while(!stack.isEmpty()) {
            ans[k - 1 - idx] = stack.pop();
            idx++;
        }
        return ans;
    }
}