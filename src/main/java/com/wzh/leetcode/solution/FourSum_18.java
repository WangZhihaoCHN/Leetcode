package com.wzh.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18.四数之和 4Sum
 * <p>
 * 题目描述：
 * 给定一个包含n个整数的数组nums和一个目标值target，
 * 判断nums中是否存在四个元素a,b,c和d，使得a+b+c+d的值
 * 与target相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum_18 {
    /*
     * 算法思路：
     *    解题思路与3Sum问题相同，只需在外部在套一层循环即可。
     *
     *  */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 异常输入
        if (nums == null || nums.length < 4)
            return res;
        // 排序
        Arrays.sort(nums);
        int nowTarget, first, last;
        for (int i = 0; i < nums.length - 3; i++) {
            // 去重
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 去重
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                nowTarget = target - nums[i] - nums[j];
                first = j + 1;
                last = nums.length - 1;
                while (first < last) {
                    List<Integer> line = new ArrayList<>();
                    if (nums[first] + nums[last] == nowTarget) {
                        line.add(nums[i]);
                        line.add(nums[j]);
                        line.add(nums[first]);
                        line.add(nums[last]);
                        res.add(line);
                        first++;
                        last--;
                        // 用于去重
                        while (first < last && nums[first] == nums[first - 1])
                            first++;
                        while (last > first && nums[last] == nums[last + 1])
                            last--;
                    } else if (nums[first] + nums[last] < nowTarget) {
                        first++;
                    } else {
                        last--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> ret = fourSum(nums, 0);
        for (List<Integer> tmp : ret) {
            for (Integer i : tmp)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
