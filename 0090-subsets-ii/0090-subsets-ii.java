class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  
        Arrays.sort(nums);  // Sort to handle duplicates  
        backtrack(nums, 0, new ArrayList<>(), result);  
        return result;  
    }  
    
    private void backtrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {  
        result.add(new ArrayList<>(tempList));  // Add current subset  
        for (int i = start; i < nums.length; i++) {  
            // Skip duplicates: if current is same as previous & previous wasn't chosen in this recursion level  
            if (i > start && nums[i] == nums[i - 1]) continue;  
            tempList.add(nums[i]);  
            backtrack(nums, i + 1, tempList, result);  
            tempList.remove(tempList.size() - 1); // backtrack  
        }  
    }
}