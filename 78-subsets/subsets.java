class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        solve(0 , (1 << n) - 1 , nums , list , new ArrayList<>() , 0);
        list.add(new ArrayList<Integer>());
        return list;
    }

    public void solve(int idx , int max , int nums[] , List<List<Integer>> list , List<Integer> currList , int bit) {
        if (idx >= nums.length) {
            return;
        }

        for (int i = idx ; i < nums.length ; i++) {
            currList.add(nums[i]);
            list.add(new ArrayList<>(currList));
            solve(i + 1 , max , nums , list , currList , bit);
            currList.remove(currList.size() - 1);
        }

        return;
    }
}