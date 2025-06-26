import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Convert list to set for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        // Memoization map: key is substring start index, value is list of sentences that can be formed from that index
        Map<Integer, List<String>> memo = new HashMap<>();
        return backtrack(s, 0, wordSet, memo);
    }
    
    private List<String> backtrack(String s, int start, Set<String> wordSet, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        List<String> results = new ArrayList<>();
        
        if (start == s.length()) {
            results.add("");
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                List<String> sublist = backtrack(s, end, wordSet, memo);
                for (String sub : sublist) {
                    String optionalSpace = sub.isEmpty() ? "" : " ";
                    results.add(word + optionalSpace + sub);
                }
            }
        }
        
        memo.put(start, results);
        return results;
    }
}