package com.wzh.leetcode.solution;

/**
 * 36. 有效的数独  Valid Sudoku
 * <p>
 * 题目描述：
 * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 1.数字1-9在每一行只能出现一次。
 * 2.数字1-9在每一列只能出现一次。
 * 3.数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 * <p>
 * 注意：
 * 1.一个有效的数独（部分已被填充）不一定是可解的。
 * 2.只需要根据以上规则，验证已经填入的数字是否有效即可。
 * <p>
 * 示例1:
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * <p>
 * 示例2:
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * <p>
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 */
public class ValidSudoku_36 {

    /**
     * 算法思路：
     */
    public static boolean isValidSudoku(char[][] board) {
        int length = board.length;
        // 对应行中是否有数字，如row[0][3]=true表示第0行有数字2
        boolean[][] row = new boolean[length][length];
        // 对应列是否有数字，如row[0][3]=true表示第0行有数字2
        boolean[][] col = new boolean[length][length];
        // 对应九宫格中是否有数字，如row[0][3]=true表示第0行有数字2
        boolean[][] cell = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 当前单元格没有值，直接跳过
                if (board[i][j] == '.') {
                    continue;
                }
                // 计算当前单元格的值
                int num = board[i][j] - '0' - 1;
                // 第几个九宫格，tips:4/3*3=3哦!
                int cellNum = i / 3 * 3 + j / 3;
                if (row[i][num] || col[j][num] || cell[cellNum][num]) {
                    return false;
                }
                row[i][num] = col[j][num] = cell[cellNum][num] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}