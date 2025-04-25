class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0 , end = 0;
        int n = nums.length;
        while(end < n) {
            if (nums[end] != 0) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start++;
            }
            end++;
        }
        return;
    }
}