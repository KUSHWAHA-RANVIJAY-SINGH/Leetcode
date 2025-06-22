import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array or throw an exception
        // (Problem constraints guarantee one solution, so this may not be necessary)
        return new int[] {};
    }
}