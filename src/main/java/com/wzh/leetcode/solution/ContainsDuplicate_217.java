package com.wzh.leetcode.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * <p>
 * 题目描述：
 * 给定一个整数数组，判断是否存在重复元素。如果存在一值在数组中出现至少两次，
 * 函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate_217 {

    /**
     * 算法思路：
     * 思路1：使用哈希集合存储每一个元素
     * 思路2：排序后两两比较
     * <p>
     * tips：HashSet add()方法，插入数据如果不存在，返回true
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        return !Arrays.stream(nums).allMatch(hashSet::add);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
