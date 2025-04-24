class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        // int n = nums.length;
        // int result = Integer.MAX_VALUE;
        // int start = 0 , end = 0;
        // int bits[] = new int[32];
        // while(end < n) {
        //     update(bits , nums[end] , 1);
        //     while(start <= end && bitsToNum(bits) >= k) {
        //         result = Math.min(result , end - start + 1);
        //         update(bits , nums[start++] , -1);
        //     }
        //     end++;
        // }
        // return result == Integer.MAX_VALUE ? -1 : result;


        int n = nums.length, start = 1, end = n + 1, mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (!isSpecial(nums, k, mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start != n + 1 ? start : -1;
    }


    private boolean isSpecial(int[] nums, int k, int len) {
        int n = nums.length;
        int[] bits = new int[32];
        for (int i = 0; i < n; i++) {
            update(bits, nums[i], 1); 
            if (i >= len) {
                update(bits, nums[i - len], -1);
            }
            if (i >= len - 1 && bitsToNum(bits) >= k) {
                return true;
            }
        }
        return false;
    }

    public void update(int bits[] , int x , int change) {
        for (int bit = 0 ; bit < 32 ; bit++) {
            if (((x >> bit) & 1) != 0) {
                bits[bit] += change;
            }
        }
    }

    public int bitsToNum(int bits[]) {
        int ans = 0;
        for (int bit = 0 ; bit < 32 ; bit++) {
            if (bits[bit] != 0) {
                ans |= 1 << bit;
            }
        }
        return ans;
    }
}