package com.wzh.leetcode.solution;

/**
 * 29. 两数相除 Divide Two Integers
 * <p>
 * 题目描述：
 * 给定两个整数，被除数dividend和除数divisor。
 * 将两数相除，要求不使用乘法、除法和mod运算符。返回
 * 被除数dividend除以除数divisor得到的商。
 * <p>
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * <p>
 * 说明:
 * 1. 被除数和除数均为 32 位有符号整数。
 * 2. 除数不为 0。
 * 3. 假设我们的环境只能存储 32 位有符号整数，其数值
 * 范围是[−2^31, 2^31−1]。本题中，如果除法结果溢出,
 * 则返回2^31−1。
 */
public class DivideTwoIntegers_29 {
    /*
     * 算法思路：
     *    整数近似除法：32/3 = 10
     * 显然求近似除法可以用乘法来二分查找：
     * 32 ~ 3*10 = 3*[1*(2^3) + 0*(2^2) + 1*(2^1) + 0*(2^0)]
     *
     * res = 0, x为所要求的答案
     * 1. 先找到a使x*2^a <= y < x*2^(a+1)，res += 2^a，y = y - x*2^a
     * 2. if(y >= x*2^(a-1) {res+=2^(a-1); y = y - x*2^(a-1);}
     * 3. if(y >= x*2^(a-2) {res+=2^(a-2); y = y - x*2^(a-2);}
     *
     * 我们设想87/4，本来应该的得到21余3，那么如果我们把87忽略余数后分解一下，
     * 87 = 4*21 = 4*16 + 4*4 + 4*1，也就是87 = 4*(1*2^4 + 0*2^3 + 1*2^2 + 0*2^1 + 1*2^0)，
     * 也就是把商分解为27 = 1*2^4 + 0*2^3 + 1*2^2 + 0*2^1 + 1*2^0，所以商的二进制是10101。
     * 我们可以不断的将4乘2的一次方，二次方，等等，直到找到最大那个次方，在这里是2的四次方。然后，
     * 我们就从四次方到零次方，按位看商的这一位该是0还是1。
     *
     * 注意：
     * 但题目不允许用乘法，可以用移位代替：x*2^i = x<<i：
     * corner case，非常重要：
     * (1) x, y可能会是负数
     * (2) x可能为0时，返回INT_MAX或INT_MIN
     * (3) INT_MIN / -1 > INT_MAX，overflow
     *
     *  */
    public static int divide(int dividend, int divisor) {
        // 异常输入
        if (dividend == Integer.MIN_VALUE && (divisor == 1 || divisor == -1)) {
            return divisor == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        // 判断正负号
        boolean flag = true;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            flag = false;
        }

        // 判断最高位有几个二进制位
        long m = Math.abs((long) dividend), n = Math.abs((long) divisor);
        long count = 0;
        while (m >= n) {
            n <<= 1;
            count++;
        }

        // 利用二进制开始除法计算
        n >>= 1;    //重置除数，把最高次方减1得到实际最高位，刚才循环中多加了一次
        long result = 0;
        count--;
        while (count >= 0) {
            if (m >= n) {
                result += (1 << count);
                m -= n;
            }
            n >>= 1;
            count--;
        }

        int res = (int) result;
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 3));
    }
}
