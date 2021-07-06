package com.wzh.leetcode.solution;

public class ClimbingStairs_70 {
    /**
     * 算法思路：
     * 按照最后一步迈多大分类，只有爬1级和爬2级两种，因此f(n) = f(n-1) + f(n-2)
     * 注：递归会超时，时间复杂度是O(2^n)。可以通过记忆化递归优化实现
     */
    public int climbStairsV1(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairsV1(n - 1) + climbStairsV1(n - 2);
        }
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] mem = new int[n + 1];
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }
}
