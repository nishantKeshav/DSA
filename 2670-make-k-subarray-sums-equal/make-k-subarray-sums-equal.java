class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        boolean cond[] = new boolean[n];

        List<Integer> temp = new ArrayList<Integer>();
        long ans = 0;

        for (int i = 0 ; i < n ; i++) {
            if (cond[i] == true) {
                continue;
            }
            int idx = i;
            while(!cond[idx]) {
                temp.add(arr[idx]);
                cond[idx] = true;
                idx = (idx + k) % n;
            }

            ans += minOperations(temp);
            temp.clear();
        }

        return ans;
    }

    public long minOperations(List<Integer> arr) {
        Collections.sort(arr);
        int median = arr.get(arr.size() / 2);
        long ops = 0;
        for (Integer num : arr) {
            ops += (Math.abs(num - median));
        }
        return ops;
    }

    // https://www.youtube.com/watch?v=4fvwsGdBdok
}