class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        int n = s.length();
        solve(s , 0 , wordDict , list , new ArrayList<String>() , n);
        return list;
    }

    public void solve(String s , int idx , List<String> wordDict , List<String> list , List<String> currList , int n) {
        if (idx == n) {
            list.add(String.join(" " , currList));
            return;
        }

        for (int endIdx = idx + 1 ; endIdx <= n ; endIdx++) {
            String split = s.substring(idx , endIdx);
            if (wordDict.contains(split)) {
                currList.add(split);
                solve(s , endIdx , wordDict , list , currList , n);
                currList.remove(currList.size() - 1);
            }
        }
        return;
    }
}