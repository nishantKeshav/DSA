class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        boolean used[] = new boolean[n + 1];
        solve(nums , list , used, new ArrayList<Integer>() , n);
        return list;
    }

    public void solve(int nums[] , List<List<Integer>> list , boolean used[] , ArrayList<Integer> currList , int n) {
        if (currList.size() == n) {
            list.add(new ArrayList<>(currList));
            return;
        }

        for (int i = 0 ; i < n ; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            currList.add(nums[i]);
            solve(nums , list , used , currList , n);
            used[i] = false;
            currList.remove(currList.size() - 1);
        }
    }
}

// class Solution {
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         Arrays.sort(nums);
//         List<Integer> list = new ArrayList<>();
//         for (int num : nums) {
//             list.add(num);
//         }
//         ans.add(list);
//         nextPermutation(nums , ans);
//         return ans;
//     }

//     public void nextPermutation(int nums[] , List<List<Integer>> ans) {
//         int breakIndex = -1;
//         int n = nums.length;
//         for (int i = n - 2 ; i >= 0 ; i--) {
//             if (nums[i] < nums[i + 1]) {
//                 breakIndex = i;
//                 break;
//             }
//         }

//         if (breakIndex == -1) {
//             return;
//         }
//         int justLargestIndex = -1;
//         for (int i = n - 1 ; i >= 0 ; i--) {
//             if (nums[i] > nums[breakIndex]) {
//                 justLargestIndex = i;
//                 break;
//             }
//         }
//         swap(nums , breakIndex , justLargestIndex);
//         reverse(nums , breakIndex + 1 , n - 1);
//         List<Integer> list = new ArrayList<>();
//         for (int num : nums) {
//             list.add(num);
//         }
//         ans.add(list);
//         nextPermutation(nums , ans);
//     }

//     public void swap(int nums[] , int i , int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }

//     public void reverse(int nums[] , int low , int high) {
//         while(low < high) {
//             swap(nums , low , high);
//             low++;
//             high--;
//         }
//     }
// }