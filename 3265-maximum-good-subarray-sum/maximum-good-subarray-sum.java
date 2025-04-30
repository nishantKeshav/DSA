class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer , Long> map = new HashMap<>();
        long ans = Long.MIN_VALUE;
        long curr_sum = 0;
        for (int num : nums) {
            if (map.containsKey(num - k)) {
                long sum = map.get(num - k);
                ans = Math.max(ans , curr_sum - sum + num);
            }
            if (map.containsKey(num + k)) {
                long sum = map.get(num + k);
                ans = Math.max(ans , curr_sum - sum + num);
            }
            long cummlative_sum;
            if (map.containsKey(num)) {
                cummlative_sum = map.get(num);
            } else {
                cummlative_sum = Long.MAX_VALUE;
            }
            map.put(num , Math.min(cummlative_sum , curr_sum));
            curr_sum += num;
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}