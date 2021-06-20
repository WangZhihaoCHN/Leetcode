package com.wzh.leetcode.solution;

import java.util.Stack;

/**
 * 20.有效的括号 Valid Parentheses
 * <p>
 * 题目描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses_20 {
    /*
     * 算法思路：
     *    构建一个栈，遍历整个输入字符串。如果遇到左半括号则执行入栈操作，
     * 如果遇到右半括号则执行出栈比较是否匹配。比较不通过，则直接返回false。
     * 最后栈为空，则返回true。
     *
     *  */
    public static boolean isValid(String s) {
        // 空串为正确
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        Character now, top;
        for (int i = 0; i < s.length(); i++) {
            now = s.charAt(i);
            if (now == '(' || now == '[' || now == '{') {
                stack.push(now);
            } else {
                if (stack.empty())
                    return false;
                top = stack.pop();
                if (now == ')' && top == '(' || now == ']' && top == '[' || now == '}' && top == '{')
                    continue;
                else
                    return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String input = "([)]";
        System.out.println(isValid(input));
    }
}
