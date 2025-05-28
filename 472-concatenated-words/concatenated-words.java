class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            Boolean dp[] = new Boolean[word.length() + 1];
            if (solve(0 , word.length() , word , set , dp)) {
                ans.add(word);
            }
        }
        return ans;
    }

    public boolean solve(int idx , int n , String word , HashSet<String> set , Boolean dp[]) {
        if (idx >= n) {
            return dp[idx] = true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        for (int j = idx ; j < n; j++) {
            if (idx == 0 && j == (n - 1)) {
                return dp[idx] = false;
            }
            String currStr = word.substring(idx , j + 1);
            if (set.contains(currStr) && solve(j + 1 , n , word , set , dp)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}

// class Solution {
//     public List<String> findAllConcatenatedWordsInADict(String[] words) {
//         List<String> result = new ArrayList<>();
//         HashSet<String> set = new HashSet<>();
//         for (String word : words) {
//             set.add(word);
//         }
//         for (String word : words) {
//             if (isConcatenated(word, set)) {
//                 result.add(word);
//             }
//         }
//         return result;
//     }
//     private boolean isConcatenated(String word, HashSet<String> set) {
//         int len = word.length();
//         if (len == 0) return false;
//         for (int i = 1; i < len; i++) {
//             String prefix = word.substring(0, i);
//             String suffix = word.substring(i);            
//             if (set.contains(prefix) && (set.contains(suffix) || isConcatenated(suffix, set))) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
