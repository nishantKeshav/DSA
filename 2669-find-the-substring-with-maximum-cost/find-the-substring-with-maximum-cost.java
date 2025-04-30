class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character , Integer> map = new HashMap<>();
        int idx = 0;
        for (char ch : chars.toCharArray()) {
            map.put(ch , vals[idx++]);
        }
        int currSum = 0 , maxSum = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                currSum += map.get(ch);
            } else {
                currSum += ((ch - 'a') + 1);
            }
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(maxSum , currSum);
        }
        return maxSum;
    }
}