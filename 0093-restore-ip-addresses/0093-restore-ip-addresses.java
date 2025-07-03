import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> path, List<String> result) {
        // If 4 segments are collected and string is fully used 
        if (path.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }
        
        // Try segments of length 1, 2, and 3 if possible
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;
            String segment = s.substring(start, start + len);

            // Check validity of segment
            if (isValid(segment)) {
                path.add(segment);
                backtrack(s, start + len, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isValid(String segment) {
        // Segment can't be empty and length can't be > 3
        if (segment.length() == 0 || segment.length() > 3) return false;
        // No leading zero unless the segment is '0'
        if (segment.charAt(0) == '0' && segment.length() > 1) return false;
        // Check if segment is <= 255
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }

    // Optional main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "25525511135";
        List<String> ips = sol.restoreIpAddresses(input);
        System.out.println(ips);
    }
}