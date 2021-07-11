package com.wzh.leetcode.solution;

public class ReverseBits_190 {
    /**
     * 算法思路：
     *
     * <p>
     * 补充:n不断逻辑右移一位，取最后一位
     * java算数左右移<<、>>，即保证符号位不变；逻辑左右移<<<、>>>>
     */
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // 当前结果左移一位，空出最低位
            result <<= 1;
            // 存放n当前的最后一位
            result |= n & 1;
            // n右移一位，移出最后一位
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int reverseBits = reverseBits(Integer.parseUnsignedInt("00000010100101000001111010011100", 2));
        System.out.println(Integer.toString(reverseBits, 2));
    }
}
