class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(0, i, j, rows, cols, board, visited, word))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs (int ind, int r, int c, int rows, int cols, char[][] board, boolean[][] visited, String word) {
        if (ind == word.length())  
            return true;
        
        if (r < 0 || c < 0 || 
                r >= rows || c >= cols || 
                word.charAt(ind) != board[r][c] || 
                visited[r][c])
            return false;
        
        visited[r][c] = true;

        boolean res = dfs(ind + 1, r + 1, c, rows, cols, board, visited, word) ||
        dfs(ind + 1, r - 1, c, rows, cols, board, visited, word) ||
        dfs(ind + 1, r, c + 1, rows, cols, board, visited, word) ||
        dfs(ind + 1, r, c - 1, rows, cols, board, visited, word);

        visited[r][c] = false;

        return res;
    }
}
