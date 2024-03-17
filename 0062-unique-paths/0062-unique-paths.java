class Solution {
    public int uniquePaths(int m, int n) {
        
        int numerator = m + n - 2; 
        int denominator = Math.min(m, n) - 1;
        long result = 1;
        
        for (int i = 0; i < denominator; i++) {
            result = result * (numerator - i) / (i + 1);
        }
        
        return (int) result;
    }
}