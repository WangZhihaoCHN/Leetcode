package com.wzh.leetcode.solution;

public class SetMatrixZeroes_73 {
    /**
     * 算法思路：
     * 我们可以用两个数组分别记录每一行和每一列是否有0出现。即遍历数组一遍，
     * 如果某个元素为0，则将当前行和当前列对应的标记数组置为true。最后，
     * 根据标记数组再次遍历原数组即可。
     * <p>
     * 优化存储空间：使用第0行和第0列存储当前行列是否包含0，同时为了防止覆盖，
     * 将第0行和第0列原本是否就包含0作为变量存储下来。
     */
    public void setZeroes(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean col0 = false, row0 = false;
        for (int i = 0; i < rowNum; i++) {
            // 每一行的第一个元素是否为0
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for (int i = 0; i < colNum; i++) {
            // 每一列的第一个元素是否为0
            if (matrix[0][i] == 0) {
                row0 = true;
                break;
            }
        }
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                // 0行0列不需要遍历，其中该是0的地方已经存储了
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0) {
            for (int i = 0; i < colNum; i++) {
                // 第0行置零
                matrix[0][i] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < rowNum; i++) {
                // 第0列置零
                matrix[i][0] = 0;
            }
        }
    }
}
