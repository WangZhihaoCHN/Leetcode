package com.wzh.leetcode.solution;

import java.util.Arrays;

/**
 * 189.旋转数组
 * <p>
 * 题目描述：
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 * <p>
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 提示:
 * 1 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 105
 */
public class RotateArray_189 {

    public static void rotate(int[] nums, int k) {
        if (nums == null
                || nums.length == 0
                || k == 0
                || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < k; i++) {
            nums[i] = copy[nums.length - k + i];
        }
        for (int i = k; i < copy.length; i++) {
            nums[i] = copy[i - k];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
        Arrays.stream(array).forEach(System.out::println);
    }
}
