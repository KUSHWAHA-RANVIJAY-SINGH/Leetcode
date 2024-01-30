class Solution {
    public int maxSubArray(int[] nums) {
     // kadane's Alogorithm 
        int maxsum = Integer.MIN_VALUE;
        int currsum=0;
        for(int i=0;i<nums.length;i++){
            currsum=Math.max(currsum+nums[i],nums[i]);
            maxsum = Math.max(maxsum,currsum);
            
        }
        return maxsum;
    }
}