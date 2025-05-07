class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[k];
        int idx = 0;
        for (int i = 0 ; i < n ; i++) {
            while(idx > 0 && ans[idx - 1] > nums[i] && ((idx - 1 + (n - i)) >= k)) {
                idx--;
            }
            if (idx < k) {
                ans[idx++] = nums[i];
            }
        }
        return ans;
    }
}


// class Solution {
//     public int[] mostCompetitive(int[] nums, int k) {
//         int n = nums.length;
//         Stack<Integer> stack = new Stack<>();
//         for (int i = 0 ; i < n ; i++) {
//             while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() + (n - i - 1) >= k) {
//                 stack.pop();
//             }
//             if (stack.size() < k) {
//                 stack.push(nums[i]);
//             }
//         }
//         System.out.println(stack);
//         int idx = 0;
//         int ans[] = new int[k];
//         while(!stack.isEmpty()) {
//             ans[k - 1 - idx] = stack.pop();
//             idx++;
//         }
//         return ans;
//     }
// }