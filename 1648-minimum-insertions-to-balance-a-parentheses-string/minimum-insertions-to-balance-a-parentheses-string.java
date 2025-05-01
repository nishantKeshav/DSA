class Solution {
    public int minInsertions(String s) {
        int openCount = 0 , openRequiredCount = 0 , closeRequiredCount = 0;
        int n = s.length();
        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openCount++;
            } else {
                if (i + 1 < n && s.charAt(i+1) == ')') {
                    i++;
                    if (openCount > 0) {
                        openCount--;
                    } else {
                        openRequiredCount++;
                    }
                } else {
                    closeRequiredCount++;
                    if (openCount > 0) {
                        openCount--;
                    } else {
                        openRequiredCount++;
                    }
                }
            }
        }
        return openRequiredCount + closeRequiredCount + (openCount * 2);
    }
}