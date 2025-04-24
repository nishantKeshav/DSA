class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int count = 0;
        int n = nums.length;
        int map[] = new int[2001];
        for (int i = 0 ; i < n ; i++) {
            map[nums[i]]++;
        }
        int k = distinctCount(map);
        map = new int[2001];
        int left = 0 , right = 0;
        while(right < n) {
            map[nums[right]]++;
            while (distinctCount(map) == k) {
                count += (n - right);
                map[nums[left]]--;
                left++;
            }
            right++;
        }
        return count;
    }

    public int distinctCount(int nums[]) {
        int count = 0;
        int n = nums.length;
        for (int i = 0 ; i < n ; i++) {
            if (nums[i] != 0) {
                count++;
            }
        }
        return count;
    }
}