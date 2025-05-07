class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length;
        int prev = 0;

        for (int i = 0; i < n && k > 0; i++) {

            if (nums[i] == prev) continue;

            int gap = nums[i] - prev - 1;
            if (gap > 0) {
                int toAdd = Math.min(k, gap);
                long start = prev + 1;
                long end = prev + toAdd;
                sum += getSum(end) - getSum(start - 1);
                k -= toAdd;
            }

            prev = nums[i];
        }

        if (k > 0) {
            long start = prev + 1;
            long end = prev + k;
            sum += getSum(end) - getSum(start - 1);
        }

        return sum;
    }

    public long getSum(long n) {
        return n * (n + 1) / 2;
    }
}
