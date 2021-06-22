package com.wzh.leetcode.solution;

import java.util.Arrays;

/**
 * 66. 加一  Plus One
 * <p>
 * 题目描述：
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。g
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例1:
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例2:
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例3:
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne_65 {

    /**
     * 算法思路：
     * 从后向前计算，如果非9，加一后结束；如果是9，当前位置0，向前进位。特殊情况：99、999等
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = ++digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        Arrays.stream(plusOne(digits)).forEach(System.out::print);
    }
}
