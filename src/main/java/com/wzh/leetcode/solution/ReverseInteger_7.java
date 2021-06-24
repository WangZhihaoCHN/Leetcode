package com.wzh.leetcode.solution;

/**
 * 7. 反转整数 Reverse Integer
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
    /**
     * 算法思路：
     * 依次获得输入数字从低位到高位的数字，进行反转。
     * <p>
     * 注意：
     * 1. 翻转后越界问题 —— 由于不能使用64位整数，因此需要验证过程可以投机为：
     * 每次计算得到的新值除以10后不等于旧值，表示越界，直接返回0
     * 2. 符号问题 —— 逐位取余，符号不会发生变化
     * 3. 终止条件 —— 不是tmp<0，因为有可能输入本身为负数
     * <p>
     * tips:为什么1对，java int计算的特性，运算结果超出了范围(Integer.MIN_VALUE~Integer.MAX_VALUE)时
     * 则发生了溢出，而且不会有任何异常抛出，计算结果为低32位的值。
     */
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = 10 * res + t;
            // 表示有溢出
            if ((newRes - t) / 10 != res) {
                return 0;
            }
            res = newRes;
            x /= 10;
        }
        return res;
    }

    public static int reverseOldVersion(int x) {
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
        System.out.println(reverse(2123456789));
    }
}
