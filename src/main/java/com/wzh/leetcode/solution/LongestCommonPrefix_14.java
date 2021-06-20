package com.wzh.leetcode.solution;

/**
 * 14.最长公共前缀 Longest Common Prefix
 * <p>
 * 题目描述：
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix_14 {
    /*
     * 算法思路：
     *    我们采用纵向比较法，思路如下：
     * 1. 比较字符串数组strs中的每一个字符串的第一个字符，如果这个字符在每个字符串中均存在且相等，
     * 则进行下一步，否则退出，返回结果strs[0].substring(0, 0)，也就是空字符串;
     * 2. 比较字符串数组strs中的每一个字符串的第二个字符，如果这个字符在每个字符串中均存在且相等，
     * 则进行下一步，否则退出，返回结果strs[0].substring(0, 1);
     * 3. 以此类推，检测第三个字符，第四个字符...;
     * 4. 比较字符串数组strs中的每一个字符串的第n个字符，n为strs[0]的字符串长度，如果这个字符在
     * 每个字符串中均存在且相等，则第一个字符串就是最长公共子串，返回strs[0]，否则退出，返回结果
     * strs[0].substring(0, n)。
     *
     *    可以看出，整个过程分为两个循环，第一个循环逐个遍历strs中第一个字符串的每个字符，
     * 第二个循环遍历strs中第二个至最后一个字符串，并检测每个字符串的对应位置的字符是否与
     * 第一个字符串对应位置的字符相等，如果全部相等，继续遍历下一个字符，否则返回结果。
     *
     *  */
    public static String longestCommonPrefix(String[] strs) {
        // 异常输入
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        char now;
        for (int i = 0; i < strs[0].length(); i++) {
            now = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                // 后续字符串比第一个字符串短 或者 当前位字符与第一个字符串不相同
                if (i >= strs[j].length() || strs[j].charAt(i) != now) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String input[] = {"aa", "a"};
        System.out.println(longestCommonPrefix(input));
    }
}