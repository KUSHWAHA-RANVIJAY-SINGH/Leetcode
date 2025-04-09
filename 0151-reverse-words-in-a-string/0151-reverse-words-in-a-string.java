class Solution {
    public String reverseWords(String s) {
          s = s.trim();  
        
        // Split the string using spaces as the delimiter  
        String[] words = s.split("\\s+");  
        
        // Use StringBuilder to construct the reversed words  
        StringBuilder reversed = new StringBuilder();  
        
        // Reverse the order of the words  
        for (int i = words.length - 1; i >= 0; i--) {  
            reversed.append(words[i]);  
            // Add a space between words, but avoid adding it after the last word  
            if (i != 0) {  
                reversed.append(" ");  
            }  
        }  
        
        return reversed.toString(); 
    }
}