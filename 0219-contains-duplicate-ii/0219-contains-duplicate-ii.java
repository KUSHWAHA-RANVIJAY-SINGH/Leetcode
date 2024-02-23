class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 1 ; i < nums.length; i++) {
            for (int j = Math.max(0, i - k); j < i; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}