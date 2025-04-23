class Solution {
    public int countLargestGroup(int n) {
        int map[] = new int[37];
        for (int i = 1 ; i <= n ; i++) {
            int sum = digitSum(i);
            map[sum]++;
        }
        // System.out.println(Arrays.toString(map));
        int max = 0;
        for (int i = 0 ; i < 37 ; i++) {
            max = Math.max(max , map[i]);
        }
        // System.out.println(max);
        int count = 0;
        for (int i = 0 ; i < 37 ; i++) {
            if (map[i] == max) {
                count++;
            }
        }
        return count;
    }
    public int digitSum(int num) {
        if (num >= 1 && num <= 9) {
            return num;
        }
        return (num % 10) + (digitSum(num / 10));
    }
}