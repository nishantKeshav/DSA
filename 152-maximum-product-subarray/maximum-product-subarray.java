class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0] , min = nums[0] , max = nums[0];
        int n = nums.length;
        for (int i = 1 ; i < n ; i++) {
            if (nums[i] == 0) {
                min = 1;
                max = 1;
                ans = Math.max(ans , 0);
            } else if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(nums[i] , min * nums[i]);
            max = Math.max(nums[i] , max * nums[i]);
            ans = Math.max(max , ans);
        }
        return ans;
    }
}