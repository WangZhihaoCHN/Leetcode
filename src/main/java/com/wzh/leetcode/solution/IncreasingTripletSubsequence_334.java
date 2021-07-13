package com.wzh.leetcode.solution;

public class IncreasingTripletSubsequence_334 {
    /**
     * 算法思路：
     * 是300题最长上升子序列的子问题
     * <p>
     * 进阶：O(n)巧解法
     * 对于一个数组要找到 small<mid<target
     * 用 small 来保存遍历到当前位置遇到的最小数字，即为满足 small<mid，因此 small 应当越小越好。
     * 用 mid 来保存当前符合 mid>small 的最小的数字，为了使其满足 mid<target。
     * mid 当然也应当越小越好，但在 mid 前面一定要有一个数字 min 使其满足 mid>min。
     * 当遍历到一个数字 target 时，若小于 small 则替换， 若小于mid 则替换，若均大于则返回true。
     * <p>
     * 说明：（为什么small总是替换为最小值也不会出问题？因为mid始终保证前面有一个数字小于它，
     * 即使我们替换了曾经的small，历史上也存在过一个比它小的数字，只要找到比它大的，
     * 就证明存在三元组。而替换操作，是为了保证找到尽可能小的mid。）
     */
    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int target : nums) {
            if (target < small) {
                small = target;
            } else if (target != small && target < mid) {
                mid = target;
            } else if (target > mid) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println(increasingTriplet(nums));
    }
}
