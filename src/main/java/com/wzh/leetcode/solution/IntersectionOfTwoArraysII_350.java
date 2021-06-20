package com.wzh.leetcode.solution;

import java.util.*;

/**
 * 350. 两个数组的交集 II  Intersection of Two Arrays II
 * <p>
 * 题目描述：
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例1:
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 示例2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class IntersectionOfTwoArraysII_350 {

    /**
     * 算法思路：
     * 解法1：Hash表，存储其中一个数组的key和count，遍历另一个数组的元素，找到(count>0)就讲Hash表中的count-1
     * <p>
     * 解法2：两数组排序+双指针
     * 若左右指针相同，添加入结果。若不同，则将较小的向右移动一格
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums1) {
            Integer count = hashMap.getOrDefault(num, 0);
            hashMap.put(num, count + 1);
        }
        List<Integer> common = new ArrayList<>();
        for (int num : nums2) {
            if (!hashMap.containsKey(num)) {
                continue;
            }
            int count = hashMap.get(num);
            if (count > 0) {
                common.add(num);
                hashMap.put(num, count - 1);
            }
        }
        int[] result = new int[common.size()];
        for (int i = 0; i < common.size(); i++) {
            result[i] = common.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Arrays.stream(intersect(nums1, nums2)).forEach(System.out::print);
    }
}
