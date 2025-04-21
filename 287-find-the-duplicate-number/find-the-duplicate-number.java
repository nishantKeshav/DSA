class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        int n = nums.length - 1;
        for (int bit = 0 ; bit < 32 ; bit++) {
            int setBits = 0 , ActualSetBits = 0;
            for (int num : nums) {
                if (((num >> bit) & 1) != 0) {
                    setBits++;
                }
            }
            for (int i = 1 ; i <= n ; i++) {
                if (((i >> bit) & 1) != 0) {
                    ActualSetBits++;
                }
            }
            if (setBits > ActualSetBits) {
                ans |= (1 << bit);
            }
        }
        return ans;

        // int slow = nums[0] , fast = nums[0];
        // do {
        //     slow = nums[slow];
        //     fast = nums[nums[fast]];
        // } while(slow != fast);
        // slow = nums[0];
        // while(slow != fast) {
        //     slow = nums[slow];
        //     fast = nums[fast];
        // }
        // return slow;
    }
}