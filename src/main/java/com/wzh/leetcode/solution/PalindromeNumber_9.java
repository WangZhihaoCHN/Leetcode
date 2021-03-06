package com.wzh.leetcode.solution;

/**
 * 9.回文数 Palindrome Number
 * <p>
 * 题目描述：
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber_9 {
    /*
     * 算法思路：
     *    比较最高位与最低位的数字：如果不同则不是回文，如果相同，则去掉最高和最低位，继续判断。
     * 直到所有位数字都被去掉，则一定是回文。关键点在于，如何取出最高和最低位的数字？比较之后
     * 如何去掉？
     * 以x = 2332为例：最高位为L，最低位为R
     * L = 2332/1000 = 2
     * R = 2332%10 = 2
     *
     * L = R所以要去掉最高最低位继续判断：令y = 1000
     * 2332 % L = 332
     * 332 / 10 = 33
     * x = (x%y)/10 = 33
     *
     * 如何继续取出最高位？由于删除了两位，y = y/100 = 10
     * L = 33/10 = 3
     * R = 33%10 = 3
     *
     * L = R所以继续去掉最高最低位：
     * x = (33%10)/10 = 0
     * x = 0标志了判断结束。
     *
     *  */
    public static boolean isPalindrome(int x) {
        // 根据输入实例，负数不可能为回文数
        if (x < 0)
            return false;

        // 计算最高位
        int len = 1;
        while (x / len >= 10) {
            len *= 10;
        }

        // 判断回文
        int left, right;
        while (x != 0) {
            left = x / len;
            right = x % 10;
            if (left != right)
                return false;
            x = (x % len) / 10;
            len /= 100;     // 因为最高位和最低位都被删除了，所以长度减少了2个十进制
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
