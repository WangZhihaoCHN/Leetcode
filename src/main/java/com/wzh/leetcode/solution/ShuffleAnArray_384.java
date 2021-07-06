package com.wzh.leetcode.solution;

import java.util.Random;

/**
 * 算法思路：
 * 公平洗牌算法，对于array数组，洗牌过程中（即遍历过程中），
 * 保证每一个元素都有同等的概率出现在当前位置上。
 */
public class ShuffleAnArray_384 {

    private final int[] original;

    public ShuffleAnArray_384(int[] nums) {
        original = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] array = original.clone();
        for (int i = 0; i < array.length; i++) {
            int j = new Random().nextInt(array.length);
            swap(array, i, j);
        }
        return array;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleAnArray_384 obj = new ShuffleAnArray_384(nums);
        int[] param_1 = obj.shuffle();
        for (int i : param_1) {
            System.out.print(i);
        }
        System.out.println();
        int[] param_2 = obj.reset();
        for (int i : param_2) {
            System.out.print(i);
        }
        System.out.println();
        int[] param_3 = obj.shuffle();
        for (int i : param_3) {
            System.out.print(i);
        }
    }
}
