class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n + 1][1000];
        // for (int arr[] : dp) {
        //     Arrays.fill(arr , -1);
        // }
        return solve(nums , n , 0 , 0 , target , dp);
    }

    public int solve(int nums[] , int n , int idx , int currVal , int target , int dp[][]) {
        if (idx == n) {
            return (currVal == target) ? 1 : 0;
        }

        // if (dp[idx][currVal] != -1) {
        //     return dp[idx][currVal];
        // }

        int total = 0;
        total += solve(nums , n , idx + 1 , currVal + nums[idx] , target , dp);
        total += solve(nums , n , idx + 1 , currVal - nums[idx] , target , dp);

        return total;
    }
}