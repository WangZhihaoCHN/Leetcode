package com.wzh.leetcode.solution;

public class PowerOfThree_326 {
    /**
     * 算法思路：
     * 乘法会超时，改为自身迭代除以3，看最终是否为1
     */
    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // 超时
    public static boolean isPowerOfThreeV1(int n) {
        if (n == 1) {
            return true;
        }
        int num = 1;
        for (int i = 1; i * 3 <= n; i++) {
            num *= 3;
            if (num == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
    }
}
