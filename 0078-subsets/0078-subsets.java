class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(tempList));
        
        for (int i = start; i < nums.length; i++) {
            // Include nums[i]
            tempList.add(nums[i]);
            // Move on to the next element
            backtrack(nums, i + 1, tempList, result);
            // Exclude nums[i]
            tempList.remove(tempList.size() - 1);
        }
    }
}