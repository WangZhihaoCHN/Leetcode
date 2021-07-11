package com.wzh.leetcode.solution;

public class MissingNumber_268 {
    /**
     * 算法思路：
     * 排序后搜索
     * <p>
     * 巧妙做法：
     * 解法1：结合数组中唯一出现的136题解，将数组与[0~n]数组进行异或，可得解
     * 解法2：利用求和公式得到[0~n]的解，减去nums数组，可得答案
     */
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }
}
