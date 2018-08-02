/* 字符串转整数 String to Integer (atoi)
 *
 * 题目描述：
 *    实现 atoi，将字符串转为整数。
 *    在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，
 * 选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个
 * 非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *    字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 *    当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，
 * 则不进行转换。
 *    若函数不能执行有效的转换，返回 0。
 *
 * 说明：
 *    假设我们的环境只能存储32位有符号整数，其数值范围是 [−2^31, 2^31−1]。
 * 如果数值超过可表示的范围，则返回 INT_MAX(2^31−1) 或 INT_MIN(−2^31) 。
 *
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 *
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字
 * 组合起来，最后得到 -42 。
 *
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。因此无法执行有效的转换。
 *
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。因此返回 INT_MIN(−2^31) 。
 *
 * */

public class Main {
    /*
     * 算法思路：
     *    从头到尾扫描字符串，并考虑以下情况：
     * 1. 若字符串开头是空格，则跳过所有空格，到第一个非空格字符，如果没有，则返回0；
     * 2. 若第一个非空格字符是符号+/-，则标记sign的真假；
     * 3. 若下一个字符不是数字，则返回0；
     * 4. 如果下一个字符是数字，则转为整形存下来，若接下来再有非数字出现，则返回目前的结果；
     * 5. 还需要考虑边界问题，如果超过了整形数的范围，则用边界值替代当前值。
     *
     *  */
    public static int myAtoi(String str) {
        // 异常输入
        if (str.isEmpty())
            return 0;
        int length = str.length();
        int sign = 1;       // 符号
        long res = 0;       // 返回值，防止溢出用long
        int index = 0;      // 一个从前向后遍历字符串的下标
        // 跳过所有字符串开头的空格
        while (index<length && str.charAt(index)==' ')
            index++;
        // 首位是符号
        if (index<length && str.charAt(index) == '+'){
            sign = 1;
            index++;
        }else if (index<length && str.charAt(index) == '-'){
            sign = -1;
            index++;
        }
        // 后续数字部分转换
        while (index<length && str.charAt(index)>='0' && str.charAt(index)<='9'){
            res = 10 * res + str.charAt(index) - '0';
            if (res*sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (res*sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            index++;
        }
        return (int)(res*sign);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
