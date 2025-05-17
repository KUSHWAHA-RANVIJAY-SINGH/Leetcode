class Solution {
    private int rows, cols;
    private boolean[][] visited;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];
        this.board = board;
        this.word = word;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, int index) {
        if (index == word.length()) {
            return true; // all letters matched
        }
        // Check boundaries and if already visited or char mismatch
        if (row < 0 || row >= rows || col < 0 || col >= cols ||
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        // Explore neighbors in 4 directions
        boolean found = backtrack(row + 1, col, index + 1) ||
                        backtrack(row - 1, col, index + 1) ||
                        backtrack(row, col + 1, index + 1) ||
                        backtrack(row, col - 1, index + 1);
        visited[row][col] = false; // backtrack

        return found;
    }
}