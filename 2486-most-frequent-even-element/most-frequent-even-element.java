class Solution {
    public int mostFrequentEven(int[] nums) {
        int freq[] = new int[100001];
        for (int num : nums) {
            freq[num]++;
        }
        int count = 0 , ele = -1;
        for (int i = 0 ; i < freq.length ; i+=1) {
            if (freq[i] != 0 && i % 2 == 0) {
                if (freq[i] > count) {
                    count = freq[i];
                    ele = i;
                }
            }
        }
        return ele;
    }
}