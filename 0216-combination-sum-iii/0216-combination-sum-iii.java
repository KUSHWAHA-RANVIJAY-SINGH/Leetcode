class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), results);
        return results;
    }
    
    private void backtrack(int k, int target, int start, List<Integer> combination, List<List<Integer>> results) {
        if (combination.size() == k && target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        if (combination.size() > k || target < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            combination.add(i);
            backtrack(k, target - i, i + 1, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}