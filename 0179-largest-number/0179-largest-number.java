class Solution {
    public String largestNumber(int[] nums) {
       String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom sort comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", the entire number is zero
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the largest number
        StringBuilder sb = new StringBuilder();
        for (String num : strNums) {
            sb.append(num);
        }
        return sb.toString(); 
    }
}