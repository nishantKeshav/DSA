class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        solve(0 , n , nums , new ArrayList<Integer>() , list);
        return list;
    }

    public void solve(int idx , int n , int nums[] , List<Integer> currList , List<List<Integer>> list) {
        if (currList.size() >= 2) {
            list.add(new ArrayList<>(currList));
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = idx ; i < n ; i++) {
            // if (i > idx && nums[i] == nums[i - 1]) {
            //     continue;
            // }
            if ((currList.isEmpty() || nums[i] >= currList.get(currList.size() - 1)) && !set.contains(nums[i])) {
                set.add(nums[i]);
                currList.add(nums[i]);
                solve(i + 1, n , nums, currList, list);
                currList.remove(currList.size() - 1);
            }
        }

        return;
    }
}