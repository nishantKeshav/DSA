class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int count = 1;
        int n = nums.length;
        for (int i = 1 ; i < n ; i++) {
            if (count == 0) {
                ele = nums[i];
                count++;
            } else {
                if (nums[i] == ele) {
                    count++;
                } else if (nums[i] != ele) {
                    count--;
                }
            }
        }
        count = 0;
        for (int num : nums) {
            if (ele == num) {
                count++;
            }
            if (count > (Math.floor(n / 2.0))) {
                return ele;
            }
        }
        return -1;
    }
}