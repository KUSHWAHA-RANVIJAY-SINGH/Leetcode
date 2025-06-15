class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int min = nums[0];
        int max = nums[0];
        int n = nums.length;
        
        // Find global min and max
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        if (min == max) {
            return 0; // all numbers are the same
        }
        
        // Calculate bucket size and count
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        
        // Initialize buckets to track min and max in each bucket
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        
        for (int i = 0; i < bucketCount; i++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }
        
        // Place each number in a bucket
        for (int num : nums) {
            int bucketIdx = (num - min) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }
        
        // Compute the maximum gap between buckets
        int maxGap = 0;
        int previousMax = bucketMax[0];
        
        for (int i = 1; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) {
                // empty bucket
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }
        
        return maxGap;
    }
}