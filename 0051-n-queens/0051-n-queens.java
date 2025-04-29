class Solution {
    public List<List<String>> solveNQueens(int n) {
         List<List<String>> results = new ArrayList<>();  
        // Use a char array for the board representation for efficiency  
        char[][] board = new char[n][n];  
        // Initialize the board with dots  
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < n; j++) {  
                board[i][j] = '.';  
            }  
        }  
        backtrack(results, board, 0, n);  
        return results;  
    }  
    
    private void backtrack(List<List<String>> results, char[][] board, int row, int n) {  
        if (row == n) {  
            results.add(construct(board));  
            return;  
        }  
        for (int col = 0; col < n; col++) {  
            if (isValid(board, row, col, n)) {  
                board[row][col] = 'Q'; // Place queen  
                backtrack(results, board, row + 1, n);  
                board[row][col] = '.'; // Remove queen (backtrack)  
            }  
        }  
    }  

    private boolean isValid(char[][] board, int row, int col, int n) {  
        // Check column  
        for (int i = 0; i < row; i++) {  
            if (board[i][col] == 'Q') {  
                return false;  
            }  
        }  
        // Check upper-left diagonal  
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {  
            if (board[i][j] == 'Q') {  
                return false;  
            }  
        }  
        // Check upper-right diagonal  
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {  
            if (board[i][j] == 'Q') {  
                return false;  
            }  
        }  
        return true;  
    }  
    
    private List<String> construct(char[][] board) {  
        List<String> res = new ArrayList<>();  
        for (char[] row : board) {  
            res.add(new String(row));  
        }  
        return res;  
    }
}