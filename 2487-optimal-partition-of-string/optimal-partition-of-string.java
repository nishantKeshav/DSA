class Solution {
    public int partitionString(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int count = 1;
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                count += 1;
                set.clear();
            }
            set.add(ch);
        }
        return count;
    }
}