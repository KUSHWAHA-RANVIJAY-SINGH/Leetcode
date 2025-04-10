class Solution {
    public int romanToInt(String s) {
         Map<Character, Integer> romanMap = new HashMap<>();  
        romanMap.put('I', 1);  
        romanMap.put('V', 5);  
        romanMap.put('X', 10);  
        romanMap.put('L', 50);  
        romanMap.put('C', 100);  
        romanMap.put('D', 500);  
        romanMap.put('M', 1000);  
        
        int total = 0; // To store the final result  
        int prevValue = 0; // To keep track of the value of the previous Roman numeral  
        
        // Iterate through each character in the string in reverse order  
        for (int i = s.length() - 1; i >= 0; i--) {  
            char currentChar = s.charAt(i);  
            int currentValue = romanMap.get(currentChar);  
            
            // If current value is less than the previous value, subtract it  
            if (currentValue < prevValue) {  
                total -= currentValue;  
            } else {  
                // Otherwise, add it to the total  
                total += currentValue;  
            }  
            // Update the previous value for the next iteration  
            prevValue = currentValue;  
        }  
        
        return total;
    }
}