class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0 , right = 0;
        int n = nums.length;
        long count = 0 , sum = 0;;
        while(right < n) {
            sum += nums[right];
            while((sum * (right - left + 1)) >= k) {
                sum -= (nums[left]);
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}