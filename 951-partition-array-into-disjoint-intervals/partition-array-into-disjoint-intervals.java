class Solution {
    public int partitionDisjoint(int[] nums) {
        int curr = nums[0] , max = nums[0];
        int n = nums.length;
        int len = 1;
        for (int i = 1 ; i < n ; i++) {
            if (curr > nums[i]) {
                len = i + 1;
                curr = max;
            } else {
                max = Math.max(max , nums[i]);
            }
        }
        return len;
    }
}