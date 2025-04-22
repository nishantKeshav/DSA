class Solution {
    public int minOperations(int[] nums, int k) {
        // int count = 0;
        // int n = nums.length;
        // for (int bit = 0 ; bit < 32 ; bit++) {
        //     int xor = 0;
        //     for (int i = 0 ; i < n ; i++) {
        //         xor ^= ((nums[i] >> bit) & 1);
        //     }
        //     if (xor != ((k >> bit) & 1)) {
        //         count++;
        //     }
        // }
        // return count;

        int xor = k;
        for (int num : nums) {
            xor ^= num;
        }
        int count = 0;
        while (xor != 0) {
            count += (xor & 1);
            xor >>= 1;
        }
        return count;
    }
}