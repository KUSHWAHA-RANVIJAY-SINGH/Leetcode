class Solution {
    public int jump(int[] nums) {
         int jumps = 0;       // Number of jumps made
        int currentEnd = 0;  // The farthest position reachable with current number of jumps
        int farthest = 0;    // The farthest position reachable with one more jump
        
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest we can reach from position i
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we've come to the end of the current jump range,
            // increase jump count and update the range to farthest reachable
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }
}