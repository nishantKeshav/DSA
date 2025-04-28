class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = (n - 1) / 2;
        int right = n - 1;
        int res[] = new int[n];
        int i = 0;
        while(left >= 0) {
            res[i++] = nums[left--];
            if (i >= n) {
                break;
            }
            res[i++] = nums[right--];
        }
        for (i = 0 ; i < n ; i++) {
            nums[i] = res[i];
        }
        return;

        // wiggle Sort 1
        // int n = nums.length;
        // for (int i = 1 ; i < n ; i++) {
        //     if (i % 2 == 1 && nums[i] <= nums[i-1]) {
        //         swap(nums , i , i-1);
        //     } else if (i % 2 == 0 && nums[i] >= nums[i-1]) {
        //         swap(nums , i , i-1);
        //     }
        // }
        // return;
    }

    public void swap(int nums[] , int a , int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}