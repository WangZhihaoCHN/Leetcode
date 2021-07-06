package com.wzh.leetcode.solution;

public class HouseRobber_198 {
    /**
     * 算法思路：
     * 动态规划。用f(n)表示前n间房子能偷到的最大金额，可得状态转移方程：
     * f(n) = max{(f(n-2)+nums[i], f(n-1)}
     * 即当偷窃第n间房子时，则不能偷窃第n-1间房子，此时最高为偷窃前n-2间房屋与当前房屋的总金额
     * 当不偷窃第n间房子时，此时最高就是偷窃前n-1间房子的总金额
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
