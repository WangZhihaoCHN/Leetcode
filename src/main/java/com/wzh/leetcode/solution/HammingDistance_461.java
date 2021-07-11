package com.wzh.leetcode.solution;

public class HammingDistance_461 {
    /**
     * 算法思路：
     * 异或得到不同位为1的结果，再运用191题解的到位1的个数。
     * <p>
     * 注：java有直接计算位1数量的函数，Integer.bitCount(x ^ y)
     */
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int count = 0;
        while (diff != 0) {
            count++;
            diff &= (diff - 1);
        }
        return count;
    }
}
