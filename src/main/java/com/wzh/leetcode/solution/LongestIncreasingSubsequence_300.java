package com.wzh.leetcode.solution;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    /**
     * 算法思路：
     * 1.动态规划
     * dp[i]表示以i结尾的最长子序列的长度
     * 因此，dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]，否则dp[i]=1
     * 即往dp[0…i−1]中最长的上升序列后面再添加一个自己
     * <p>
     * 2.贪心+二分查找（详细看官方题解）
     * 使用一个数组d保存每个长度上升子序列末尾元素的最小值。
     * 遍历nums数组的过程中，使用二分法找到d[i-1]<nums[j]<d[i]的下标i，并替换d[i]为nums[j]
     * 解释：为什么只需要更新d[i]（即结尾元素大于nums[j]的较短的最长子序列)即可呢？
     * 因为数组d中存储的是最小尾元素，因此d[i-1]>nums[j]就保证了，
     * 长度为i的最长子序列之前一定有i-1个元素小于nums[j]且能够构成上升序列，因此只需要替换d[i]，
     * 保证i长度结尾的最小末尾元素正确即可。
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // 最小值，以当前元素单独构成一个序列
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            // 从小到大构件dp数组
            for (int j = 0; j < i; j++) {
                // 遍历历史值，查找是否有j小于当前值，且dp[j]+1更长的情况
                if (nums[j] < nums[i]) {
                    // 满足条件的最长子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // dp数组中的最大值即为所求
        return Arrays.stream(dp).reduce(Integer.MIN_VALUE, Math::max);
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
