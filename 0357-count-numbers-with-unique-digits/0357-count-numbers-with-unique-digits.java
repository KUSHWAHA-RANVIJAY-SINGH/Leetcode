public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        int count = 10; // For n = 1, digits 0-9
        int uniqueDigits = 9;
        int availableNumber = 9;
        
        while (n > 1 && availableNumber > 0) {
            uniqueDigits *= availableNumber;
            count += uniqueDigits;
            availableNumber--;
            n--;
        }
        
        return count;
    }
}