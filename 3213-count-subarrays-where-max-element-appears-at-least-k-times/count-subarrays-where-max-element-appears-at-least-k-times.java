class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int left = 0 , right = 0;
        int max = Arrays.stream(nums).max().orElseThrow(() -> new RuntimeException("Array is empty"));
        int count = 0;
        while(right < n) {
            if (max == nums[right]) {
                count++;
            }
            while(count >= k) {
                ans += (n - right);
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}