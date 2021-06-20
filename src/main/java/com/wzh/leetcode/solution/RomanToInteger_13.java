package com.wzh.leetcode.solution;

import java.util.HashMap;

/**
 * 13.罗马数字转整数 Roman to Integer
 * <p>
 * 题目描述：
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如，罗马数字2写做II，即为两个并列的1。12写做XII，即为X+II。
 * 27写做XXVII, 即为 XX+V+II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如4不写做IIII，而是 IV。数字1在数字5的左边，所表示的数等于
 * 大数5减小数1得到的数值4。同样地，数字 9 表示为 IX。这个特殊的
 * 规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class RomanToInteger_13 {
    /*
     * 算法思路：
     *    用hashmap来保存罗马数字与数值的对应关系，可以使每次的
     * 查找时间为O(1)，最终时间复杂度为O(n)。
     *    从头到尾的遍历数组，并通过hashmap来获得对应数值，并依次
     * 累加到最终结果。但这得到的显然并不是正确的答案，因为有几种
     * 特殊情况，即 IV=4, IX=9 …… 观察后可发现，该种情况可以通过
     * 扫描过程中，出现后一个数now大于前一个数pre来判别。而此时，
     * 由于前数pre已经被加过一次了，所以需要减去它pre，且当前需要
     * 加上的数为now-pre，所以遇到这种情况，result应该+now-2*pre。
     *    综上，可求解问题。
     *
     *  */
    public static int romanToInt(String s) {
        // 异常输入
        if (s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        Integer pre = 1000, now;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            now = hm.get(s.charAt(i));
            if (now > pre)
                result = result + now - 2 * pre;
            else
                result += now;
            pre = now;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }
}
