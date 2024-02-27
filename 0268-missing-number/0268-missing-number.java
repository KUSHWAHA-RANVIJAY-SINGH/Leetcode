class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;

        // bubble sort
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size - i - 1; ++j) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }

        // find the first item's value and its index is different
        for (int i = 0; i < size; ++i) {
            if (i != nums[i]) {
                return i;
            }
        }

        return size;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
