package com.wzh.leetcode.solution;

public class MaximumSubarray_53 {
    /**
     * 算法思路：
     * 动态规划。用f(n)表示以第n个元素结尾的「连续子数组的最大和」，可得状态转移方程：
     * f(n) = max{(f(n-1)+nums[i], nums[i]}
     * 即nums[i]单独成为一段，还是加入f(n-1)的那一段
     */
    public static int maxSubArray(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int[] result = new int[nums.length + 1];
        result[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            result[i + 1] = Math.max(result[i] + nums[i], nums[i]);
            if (result[i + 1] > maxValue) {
                maxValue = result[i + 1];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
