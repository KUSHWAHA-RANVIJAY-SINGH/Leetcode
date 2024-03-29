public class Solution {
      public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, 0, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void solve(int[] candidates, int pos, int target, int runner, List<Integer> current, List<List<Integer>> result) {
        if (runner > target) {
            return;
        } else if (runner == target) {
            result.add(new ArrayList<>(current));
        } else {

            for (int i = pos; i < candidates.length; i++) {
                if (i != pos && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                current.add(candidates[i]);
                solve(candidates, i, target, runner + candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}