class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, list, candidates, target, 0, new ArrayList<Integer>());
        return list;
    }

    public void solve(int idx, List<List<Integer>> list, int arr[], int target, int currSum, List<Integer> currList) {
        if (currSum > target) {
            return;
        }

        if (currSum == target) {
            list.add(new ArrayList<>(currList));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) {
                continue;
            }

            currSum += arr[i];
            currList.add(arr[i]);

            solve(i + 1, list, arr, target, currSum, currList);

            currSum -= arr[i];
            currList.remove(currList.size() - 1);
        }

        return;
    }
}
