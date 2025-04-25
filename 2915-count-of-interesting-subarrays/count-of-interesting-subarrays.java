class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int arr[] = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = (nums.get(i) % modulo == k) ? 1 : 0;
        }

        for(int i = 1 ; i < n ; i++) {
            arr[i] += arr[i-1];
        }
        long ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);

        for (int sum : arr) {
            int currentMod = sum % modulo;
            if (currentMod < 0) {
                currentMod += (modulo);
            }

            int targetMod = (currentMod - k + modulo) % modulo;
            ans += map.getOrDefault(targetMod , 0);

            map.put(currentMod , map.getOrDefault(currentMod , 0) + 1);
        }

        return ans;
    }
}