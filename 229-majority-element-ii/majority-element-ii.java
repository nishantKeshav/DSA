class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = Integer.MIN_VALUE , ele2 = Integer.MIN_VALUE;
        int count1 = 0 , count2 = 0;
        int n = nums.length;
        for (int i = 0 ; i < n ; i++) {
            if (count1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                count2 = 1;
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (ele1 == num) {
                count1++;
            } else if (ele2 == num) {
                count2++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (count1 > Math.floor(n / 3.0)) {
            list.add(ele1);
        }
        if (count2 > Math.floor(n / 3.0)) {
            list.add(ele2);
        }
        return list;
    }
}