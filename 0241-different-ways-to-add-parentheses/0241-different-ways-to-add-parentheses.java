import java.util.*;

class Solution {
    private Map<String, List<Integer>> memo = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                
                for (int l : left) {
                    for (int r : right) {
                        int val = 0;
                        switch(c) {
                            case '+': val = l + r; break;
                            case '-': val = l - r; break;
                            case '*': val = l * r; break;
                        }
                        res.add(val);
                    }
                }
            }
        }
        
        // If res is empty, it means expression contains no operators, so parse it as an integer
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        
        memo.put(expression, res);
        return res;
    }
}