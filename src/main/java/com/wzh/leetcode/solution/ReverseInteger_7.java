package com.wzh.leetcode.solution;

/**
 * 7.反转整数 Reverse Integer
 * <p>
 * 题目描述：
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31−1]。
 * 根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class ReverseInteger_7 {
    /*
     * 算法思路：
     *    依次获得输入数字从低位到高位的数字，进行反转。
     *
     * 注意：
     *    1. 翻转后越界问题 —— 用long保存结果，返回前做判断
     *    2. 符号问题 —— 逐位取余，符号不会发生变化
     *    3. 终止条件 —— 不是tmp<0，因为有可能输入本身为负数
     *
     *  */
    public static int reverse(int x) {
        long res = 0;
        int tmp = x;
        while (tmp != 0) {
            res = 10 * res + tmp % 10;
            tmp /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
