public class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(-1);  // Base index for valid substring calculation

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}