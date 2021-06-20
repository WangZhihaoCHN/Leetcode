package com.wzh.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和 3Sum
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
public class ThreeSum_15 {
    /*
     * 算法思路：
     *    题目要求的是a+b+c=0，问题可以推广到a+b+c=target。
     * 3sum问题可以转化为2sum问题：对于任意一个A[i]，在数组中
     * 的其他数中解2sum问题，目标为target-A[i]。与2sum那题
     * 不同，这题要求返回的不是index而是数字本身，并且解不唯一。
     * 同时要求解排序并去重。
     *
     *    对排序来说，2sum中的双指针法更为方便，因为算法本身就
     * 用到排序。双指针排序法本身会去除一些重复的可能性：
     * (1, 2, 3, 4), target = 6
     * 在扫描1时，解(2, 3, 4)的2sum = 5问题，找到一个解(1, 2, 3)。
     * 在扫描2时，应当只对后面的数解2sum问题，即对(3, 4)解2sum = 4问题。这样避免再次重复找到解(1, 2, 3)。

     *    但当存在重复数字时，光靠排序仍然无法去重：
     * (1, 2, 2, 2, 3, 4), target = 9
     * 扫描第一个2时，解(2, 2, 3, 4)中的2sum=7问题，得到解(2, 3, 4)
     * 扫描第二个2时，解(2, 3, 4)中的2sum=7问题，仍然会得到(2, 3, 4)
     *
     *    去除因重复数字而造成重复解有两个办法，一是将结果存到一个hash table中，
     * 但增加额外存储空间。而另一种方法就是在扫描数组时跳过重复的数字。如上例中，
     * 只扫描1, 2, 3, 4来求相应的2sum问题。进一步简化，可以只扫描1, 2。因为3
     * 已经是倒数第二个数字，不可能有以它为最小数字的解。
     *
     *  */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 异常输入
        if (nums == null || nums.length < 3)
            return res;
        // 排序
        Arrays.sort(nums);
        int target, pre = 0, first, last;
        /* 遍历所有可能作为target值得数，但由于结果要求去重且有序，
        因此从小到大遍历，且相同数字跳过。由于需要三个数，所以target
        值最多能取到倒数第三个数字。*/
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重
            if (i != 0 && pre == nums[i])
                continue;
            pre = nums[i];
            target = -1 * nums[i];
            first = i + 1;
            last = nums.length - 1;
            while (first < last) {
                List<Integer> line = new ArrayList<>();
                if (nums[first] + nums[last] == target) {
                    line.add(nums[i]);
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
                } else if (nums[first] + nums[last] < target) {
                    first++;
                } else {
                    last--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = threeSum(nums);
        for (List<Integer> tmp : ret) {
            for (Integer i : tmp)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
