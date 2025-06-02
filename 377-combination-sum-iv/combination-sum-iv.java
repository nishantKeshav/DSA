class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        Integer dp[][] = new Integer[n + 1][target + 1];
        return solve(0 , n , nums , target , 0 , dp);   
    }

    public int solve(int idx , int n , int nums[] , int target , int currSum , Integer dp[][]) {
        if (currSum > target) {
            return 0;
        }
        
        if (currSum == target) {
            return 1;
        }

        if (dp[idx][currSum] != null) {
            return dp[idx][currSum];
        }

        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            currSum += nums[i];
            count += solve(i , n , nums , target , currSum , dp);
            currSum -= nums[i];
        }
        return dp[idx][currSum] = count;
    }
}