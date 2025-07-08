public class Solution {
    public int getMoneyAmount(int n) {
        // dp[i][j] represents the minimum cost to guarantee a win for the range [i, j]
        int[][] dp = new int[n + 1][n + 1];

        // Fill dp from bottom to top, left to right
        for (int length = 2; length <= n; length++) {
            for (int start = 1; start <= n - length + 1; start++) {
                int end = start + length - 1;
                dp[start][end] = Integer.MAX_VALUE;
                // Try all guesses k from start to end - 1
                for (int k = start; k < end; k++) {
                    // Cost when we pick k: pay k + the worst cost of subranges
                    int cost = k + Math.max(dp[start][k - 1], dp[k + 1][end]);
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        return dp[1][n];
    }
}