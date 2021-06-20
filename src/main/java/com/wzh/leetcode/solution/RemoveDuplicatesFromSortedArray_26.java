package com.wzh.leetcode.solution;

/**
 * 26. 删除排序数组中的重复项 Remove Duplicates from Sorted Array
 * <p>
 * 题目描述：
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，
 * 返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组并在
 * 使用O(1)额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组nums=[1,1,2],函数应该返回新的长度2, 并且原数组nums的前两个元素
 * 被修改为1,2。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定nums=[0,0,1,1,1,2,2,3,3,4],函数应该返回新的长度5, 并且原数组nums的
 * 前五个元素被修改为 0, 1, 2, 3, 4。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesFromSortedArray_26 {
    /*
     * 算法思路：
     *     利用一前一后两个指针，前指针pre指向数组首元素，
     * 后指针i依此遍历数组中的剩余元素。当i指向的元素与pre
     * 指向的元素相同时，不进行任何操作；而当两者不同时，
     * pre后移一个，替换当前pre位置的元素i指向的元素。
     * 然后继续执行遍历操作。
     *     该方法可以通过将pre指针依此后移，构建不重复的递增
     * 数组前续。递增性是优于原数组为排序数组保证的，不重复
     * 则是通过前后指针比较指向元素是否相等来实现去除的。
     *
     *  */
    public static int removeDuplicates(int[] nums) {
        // 异常输入
        if (nums == null || nums.length == 0)
            return 0;
        int pre = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[pre])
                continue;
            count++;
            pre++;
            nums[pre] = nums[i];
        }
        return count;
    }


    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = removeDuplicates(nums);
        for (int i = 0; i < count; i++)
            System.out.print(nums[i] + " ");
    }
}
