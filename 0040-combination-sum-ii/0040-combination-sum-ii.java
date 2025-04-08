class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();  
        Arrays.sort(candidates); // Sort candidates to handle duplicates easily  
        backtrack(result, new ArrayList<>(), candidates, target, 0);  
        return result;  
    }  
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {  
        if (remain == 0) {  
            result.add(new ArrayList<>(tempList)); // Found a valid combination  
            return;  
        }  
        for (int i = start; i < candidates.length; i++) {  
            if (remain < candidates[i]) break; // No need to continue if the remaining sum is less than the current candidate  
            if (i > start && candidates[i] == candidates[i - 1]) continue; // Skip duplicates  
            tempList.add(candidates[i]);  
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1); // Move to the next index  
            tempList.remove(tempList.size() - 1); // Backtrack  
        }  
    }
}