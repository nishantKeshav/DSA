class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // Brute Force Solution
        // int count = 0;
        // for (int start = lower; start <= upper; start++) {
        //     int current = start;
        //     boolean valid = true;
        //     for (int diff : differences) {
        //         current += diff;
        //         if (current < lower || current > upper) {
        //             valid = false;
        //             break;
        //         }
        //     }
        //     if (valid) {
        //         count++;
        //     }
        // }
        // return count;


        // Optimal Solution
        int curr = 0 , minVal = 0 , maxVal = 0;
        for (int diff : differences) {
            curr += diff;
            minVal = Math.min(minVal , curr);
            maxVal = Math.max(maxVal , curr);
            if ((upper - maxVal) - (lower - minVal) + 1 <= 0) {
                return 0;
            }
        }
        return (upper - maxVal) - (lower - minVal) + 1;
    }
}
