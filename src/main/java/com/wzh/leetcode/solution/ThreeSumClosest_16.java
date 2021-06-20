package com.wzh.leetcode.solution;

import java.util.Arrays;

/**
 * 16.最近三数之和 3Sum Closest
 * <p>
 * 题目描述：
 * 给定一个包含n个整数的数组nums，判断nums中是否存在三个元素
 * a，b，c，使得 a+b+c=0？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 满足要求的三元组集合为：
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSumClosest_16 {
    /*
     * 算法思路：
     *    这道题让我们求最接近给定值的三数之和，是在之前那道15.三数之和的
     * 基础上又增加了些许难度，那么这道题让我们返回这个最接近于给定值的值，
     * 即我们要保证当前三数和跟给定值之间的差的绝对值最小，所以我们需要定义
     * 一个变量diff用来记录差的绝对值，然后我们还是要先将数组排个序，然后
     * 开始遍历数组，思路跟那道三数之和很相似，都是先确定一个数，然后用两个
     * 指针left和right来滑动寻找另外两个数，每确定两个数，我们求出此三数
     * 之和，然后算和给定值的差的绝对值存在newDiff中，然后和diff比较并
     * 更新diff和结果closest即可。
     *
     *  */
    public static int threeSumClosest(int[] nums, int target) {
        // 异常输入
        if (nums == null || nums.length < 3)
            return 0;
        // 排序
        Arrays.sort(nums);
        int new_target, pre = 0, first, last;
        int dif = Integer.MAX_VALUE, nowDif;
        /* 遍历数组中所有数，将target-该数作为目标值。但由于结果要求
        去重且有序，因此从小到大遍历，且相同数字跳过。由于需要三个数，
        所以target值最多能取到倒数第三个数字。*/
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重
            if (i != 0 && pre == nums[i])
                continue;
            pre = nums[i];
            first = i + 1;
            last = nums.length - 1;
            while (first < last) {
                nowDif = target - (nums[first] + nums[last] + nums[i]);
                if (Math.abs(nowDif) < Math.abs(dif))
                    dif = nowDif;
                if (nowDif > 0)
                    first++;
                else
                    last--;
            }
        }
        return target - dif;
    }

    public static void main(String[] args) {
        int nums[] = {0, 2, 1, -3};
        System.out.print(threeSumClosest(nums, 1));
    }
}
