package com.wzh.leetcode.solution;

import java.util.Arrays;

public class CountPrimes_204 {
    /**
     * 算法思路：
     * 埃拉托斯特尼筛选法(埃氏筛)
     * 从小到大遍历一个数，如果是质数则将其所有的倍数都标记为合数。
     * <p>
     * 优化：
     * 对于一个质数x，如果按上文说的我们从2x开始标记其实是冗余的，
     * 应该直接从x*x开始标记，因为2x,3x,…这些数一定在x*x之前
     * 就被其他数的倍数标记过了，例如2的所有倍数，3的所有倍数等
     */
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                result++;
                for (long j = (long) i * i; j < n; j += i) {
                    isPrimes[(int) j] = false;
                }
            }
        }
        return result;
    }

    // 超时
    public int countPrimesV1(int n) {
        int result = 0;
        for (int i = 2; i < n; i++) {
            result += isPrimes(i) ? 1 : 0;
        }
        return result;
    }

    private boolean isPrimes(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 499979;
        System.out.println(new CountPrimes_204().countPrimes(n));
    }
}
