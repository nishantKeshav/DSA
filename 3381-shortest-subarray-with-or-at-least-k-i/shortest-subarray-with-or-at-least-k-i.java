class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int bits[] = new int[32];
        int n = nums.length;
        int start = 0 , end = 0;
        int maxLen = Integer.MAX_VALUE;
        while(end < n) {
            updateBits(bits , nums[end] , 1);
            while(start <= end && bitsToNum(bits) >= k) {
                maxLen = Math.min(maxLen , (end - start + 1));
                updateBits(bits , nums[start] , -1);
                start++;
            }
            end++;
        }
        return maxLen == Integer.MAX_VALUE ? -1 : maxLen;
    }

    public void updateBits(int bits[] , int num , int val) {
        for (int bit = 0 ; bit < 32 ; bit++) {
            if (((num >> bit) & 1) != 0) {
                bits[bit] += val;
            }
        }
    }

    public int bitsToNum(int bits[]) {
        int val = 0;
        for (int i = 0 ; i < 32 ; i++) {
            if (bits[i] != 0) {
                val += (1 << i);
            }
        }
        return val;
    }
}