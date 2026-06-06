class NumMatrix {
    int[][] matrixSum;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length; 

        matrixSum = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            int prefix = 0;
            for (int j = 0; j < cols; j++) {
                prefix += matrix[i][j];
                int above = matrixSum[i][j + 1];
                matrixSum[i + 1][j + 1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bottomRight = matrixSum[row2 + 1][col2 + 1];
        int topLeft = matrixSum[row1][col1];
        int left = matrixSum[row2 + 1][col1];
        int above = matrixSum[row1][col2 + 1];

        return bottomRight + topLeft - (above + left);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */