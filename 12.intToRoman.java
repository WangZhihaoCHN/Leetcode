/* 盛最多水的容器 Container With Most Water
 *
 * 题目描述：
 *    罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 *     例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *     通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 *    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 * 输入: 3
 * 输出: "III"
 *
 * 示例 2:
 * 输入: 4
 * 输出: "IV"
 *
 * 示例 3:
 * 输入: 9
 * 输出: "IX"
 *
 * 示例 4:
 * 输入: 58
 * 输出: "LVIII"
 * 解释: C = 100, L = 50, XXX = 30, III = 3.
 *
 * 示例 5:
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * */

public class Main {
    /*
     * 算法思路：
     *     我们可以分为四类，100到300一类，400一类，500到800一类，900最后一类。
     * 每一位上的情况都是类似的。
     *
     *  */
    public static String intToRoman(int num) {
        int number[] = {1000, 500, 100, 50, 10, 5, 1};
        char roman[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        StringBuilder sb = new StringBuilder();
        int now;
        for(int i=0; i<number.length; i+=2) {
            now = num/number[i];
            if(now == 0) {
                continue;
            }else if(now<4) {
                for(int j=0; j<now; j++)
                    sb.append(roman[i]);
            }else if(now == 4) {
                sb.append(roman[i]);
                sb.append(roman[i-1]);
            }else if (now == 9) {
                sb.append(roman[i]);
                sb.append(roman[i-2]);
            }else {
                sb.append(roman[i-1]);
                for(int j=0; j<now-5; j++)
                    sb.append(roman[i]);
            }
            num %= number[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}