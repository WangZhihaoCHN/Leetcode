package com.wzh.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 17.电话号码的字母组合 Letter Combinations of a Phone Number
 * <p>
 * 题目描述：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinationsOfAPhoneNumber_17 {
    /*
     * 算法思路：
     *    组合问题，利用DFS递归解决。
     *    首先建立一个从数字到字母的转换表，这样方便每一层递归遍历获得
     * 当前digits[i]所对应的所有字母。然后，通过递归不断加入当前数字
     * 对应的字母到StringBuilder中，并传递到下一层递归。直到遍历完所有
     * 数字时，递归结束。
     *
     *  */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 异常输入
        if (digits == null || digits.length() == 0)
            return result;
        // 记录电话键盘对应字母情况
        String keyboard[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        buildResult(digits, 0, sb, keyboard, result);
        return result;
    }

    /*
     * Params:
     *   digits:     原始输入数字构成的字符串；
     *   index:      当前迭代步骤处理到了输入字符串的哪一位；
     *   sb:         当前已构建的字符串前缀部分
     *   keyboard:   电话键盘与字母对应字典
     *   result:     用于保存返回结果
     * */
    public static void buildResult(String digits, int index, StringBuilder sb,
                                   String[] keyboard, List<String> result) {
        // 判断迭代是否结束
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        // 转换当前处理到的数字
        int nowNum = digits.charAt(index) - '0';
        for (int i = 0; i < keyboard[nowNum].length(); i++) {
            sb.append(keyboard[nowNum].charAt(i));
            buildResult(digits, index + 1, sb, keyboard, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String input = "23";
        List<String> list = letterCombinations(input);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
