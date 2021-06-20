package com.wzh.leetcode.solution;

import java.util.HashMap;

/**
 * 1.两数之和 Two Sum
 * <p>
 * 题目描述：
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum_1 {
    /*
     * 算法思路：
     *    最简单的思路，遍历所有二元组可能，判断相加是否为target，时间复杂度为O(n^2)，超时。
     *
     *    可以通过哈希表，以空间换时间的方法。
     *    首先遍历一次数组num[]，以数组元素num[i]的值为key，以数组下标i为值，建立哈希表。
     * 之后，在次遍历数组，读入元素num[i]，判断哈希表中是否有key值为target-num[i]的元素。
     * 如果有，显然已找到，输出对应value值和当前元素下标即可。
     *    上面的过程可以融合为一次遍历数组的过程。
     *
     *  */
    public static int[] twoSum(int[] nums, int target) {
        // 返回值，和为target的量元素下标
        int[] ret = new int[2];
        // 哈希表，存储数组中的每个元素及其下标
        HashMap<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numbers.containsKey(target - nums[i])) {   // 哈希表中无满足条件的元素
                numbers.put(nums[i], i);
            } else {              // 哈希表中有满足和为target的元素
                ret[0] = numbers.get(target - nums[i]);
                ret[1] = i;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int ret[] = twoSum(nums, 9);
        System.out.println(ret[0] + " " + ret[1]);
    }
}
