import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Pair, Integer> dp = new HashMap<>();
        return solve(nums, n, 0, 0, target, dp);
    }

    public int solve(int[] nums, int n, int idx, int currVal, int target, Map<Pair, Integer> dp) {
        if (idx == n) {
            return (currVal == target) ? 1 : 0;
        }

        Pair pair = new Pair(idx, currVal);
        if (dp.containsKey(pair)) {
            return dp.get(pair);
        }

        int total = 0;
        total += solve(nums, n, idx + 1, currVal + nums[idx], target, dp);
        total += solve(nums, n, idx + 1, currVal - nums[idx], target, dp);

        dp.put(pair, total);

        return total;
    }
}

class Pair {
    int idx;
    int currVal;

    Pair(int idx, int currVal) {
        this.idx = idx;
        this.currVal = currVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair other = (Pair) o;
        return idx == other.idx && currVal == other.currVal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idx, currVal);
    }
}
