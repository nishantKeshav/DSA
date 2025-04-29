class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int rightMin[] = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2 ; i >= 0 ; i--) {
            rightMin[i] = Math.min(rightMin[i+1] , nums[i]);
        }
        int leftMax = nums[0];
        for (int i = 1 ; i < n - 1 ; i++) {
            if (nums[i] > leftMax && nums[i] < rightMin[i + 1]) {
                sum += 2;
            } else if (nums[i + 1] > nums[i] && nums[i] > nums[i-1]) {
                sum += 1;
            }
            leftMax = Math.max(leftMax , nums[i]);
        }
        return sum;
    }
}