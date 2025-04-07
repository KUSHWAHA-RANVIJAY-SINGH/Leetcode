class Solution {
    public List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> result = new ArrayList<>();  
        boolean[] used = new boolean[nums.length];  
        backtrack(result, new ArrayList<>(), nums, used);  
        return result;  
    }  

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {  
        // Base case: if current permutation is the same length as original array  
        if (current.size() == nums.length) {  
            result.add(new ArrayList<>(current));  
            return;  
        }  

        // Explore each number in nums  
        for (int i = 0; i < nums.length; i++) {  
            // Skip used numbers  
            if (used[i]) continue;  

            // Include this number in the current permutation  
            current.add(nums[i]);  
            used[i] = true;  

            // Recur  
            backtrack(result, current, nums, used);  

            // Backtrack: remove the last number and mark it as unused  
            current.remove(current.size() - 1);  
            used[i] = false;  
        }  
    }
}