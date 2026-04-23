class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int initialColor = image[sr][sc];

        if (initialColor == color)
            return image;
        
        dfs(sr, sc, rows, cols, initialColor, color, image);

        return image;
    }

    private void dfs(int i, int j, int rows, int cols, int initialColor, int color, int[][] image) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || image[i][j] != initialColor)
            return;
        
        image[i][j] = color;
        dfs(i + 1, j, rows, cols, initialColor, color, image);
        dfs(i - 1, j, rows, cols, initialColor, color, image);
        dfs(i, j + 1, rows, cols, initialColor, color, image);
        dfs(i, j - 1, rows, cols, initialColor, color, image);
    }
}