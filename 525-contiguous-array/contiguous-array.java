class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0 ; i < n ; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        int curr_sum = 0 , max_len = 0;
        map.put(0 , -1);
        for (int i = 0 ; i < n ; i++) {
            curr_sum += nums[i];
            if (map.containsKey(curr_sum)) {
                max_len = Math.max(max_len , i - map.get(curr_sum));
            } else {
                map.put(curr_sum , i);
            }
        }
        return max_len;
    }
}