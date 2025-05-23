class Solution {
    public int longestConsecutive(int[] nums) {
         if (nums == null || nums.length == 0) return 0;  

        Set<Integer> numSet = new HashSet<>();  
        for (int num : nums) {  
            numSet.add(num);  
        }  

        int longestStreak = 0;  

        for (int num : numSet) {  
            // Only try to build sequences from numbers that are the start of a sequence  
            if (!numSet.contains(num - 1)) {  
                int currentNum = num;  
                int currentStreak = 1;  

                while (numSet.contains(currentNum + 1)) {  
                    currentNum++;  
                    currentStreak++;  
                }  

                longestStreak = Math.max(longestStreak, currentStreak);  
            }  
        }  

        return longestStreak;  
    }
}