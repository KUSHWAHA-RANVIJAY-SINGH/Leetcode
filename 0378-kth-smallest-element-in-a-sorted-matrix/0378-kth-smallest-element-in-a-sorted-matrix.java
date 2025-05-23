class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // Min-heap: elements are int[]{value, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Initialize heap with the first element of each row (only row 0 actually)
        // Alternatively, to prevent duplicates, push only the first column elements of row 0.
        // Here we push the first element of the matrix
        minHeap.offer(new int[]{matrix[0][0], 0, 0});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[] cur = null;
        for (int i = 0; i < k; i++) {
            cur = minHeap.poll();

            int row = cur[1], col = cur[2];

            // Add the next element in the row (col+1)
            if (col + 1 < n && !visited[row][col + 1]) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
                visited[row][col + 1] = true;
            }

            // Add the next element in the column (row+1)
            if (row + 1 < n && !visited[row + 1][col]) {
                minHeap.offer(new int[]{matrix[row + 1][col], row + 1, col});
                visited[row + 1][col] = true;
            }
        }

        return cur[0];
    }
}