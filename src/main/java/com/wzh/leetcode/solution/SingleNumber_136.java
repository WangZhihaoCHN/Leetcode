package com.wzh.leetcode.solution;

import java.util.Arrays;

/**
 * 136. 只出现一次的数字 Single Number
 * <p>
 * 题目描述：
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber_136 {

    /**
     * 算法思路：
     * 解法1(最佳时空复杂度)： 异或，因为异或的运算律：
     * 1)任何数和0做异或运算，结果仍然是原来的数
     * 2)任何数和其自身做异或运算，结果是0
     * 3)异或运算满足交换律和结合律
     * <p>
     * 解法2：Hash集合存储没有放进去，有就移出来
     * 或者用Hash表存储key与count
     */
    public static int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }
}
