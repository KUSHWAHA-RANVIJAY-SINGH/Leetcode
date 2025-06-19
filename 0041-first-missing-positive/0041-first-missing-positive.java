class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negative numbers, zeros,
        // and numbers larger than n by a placeholder (n+1)
        // because these numbers cannot be the answer.
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark each number present by negating
        // the number at the corresponding index.
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) continue;
            num--;  // zero-based index
            if (nums[num] > 0) {
                nums[num] = -nums[num];  // mark as found
            }
        }

        // Step 3: The first index with a positive number
        // indicates the missing number.
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // If all indices are marked, answer is n+1
        return n + 1;
    }
}