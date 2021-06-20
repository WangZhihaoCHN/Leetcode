package com.wzh.leetcode.solution;

/**
 * 5.最长回文子串 Longest Palindromic Substring
 * <p>
 * 题目描述：
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * <p>
 * 示例2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring_5 {
    /*
     * 算法思路：
     *    从左到右遍历字符串，考虑每一个可能为回文串中心位置的轴点（可以是一个字符，
     * 或者是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙，
     * 例如aba是回文，abba也是回文，这两种情况要分情况考虑），根据这个轴点往两边同时
     * 进行扫描，直到不是回文串为止（以该点为轴的最长回文子串）。遍历结束，即可找到
     * 答案。
     *    假设字符串的长度为n，那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。
     * 对于每个中心往两边扫描的复杂度为O(n)，所以时间复杂度为O((2*n-1)*n)=O(n^2)，
     * 空间复杂度为O(1)。
     *
     *  */
    public static String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = lengthOfPalindromic(s, i, i);
            result = result.length() >= temp.length() ? result : temp;
            temp = lengthOfPalindromic(s, i, i + 1);
            result = result.length() >= temp.length() ? result : temp;
        }
        return result;
    }

    private static String lengthOfPalindromic(String s, int left, int right) {
        if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right))
            return s.substring(left + 1, right);
        return lengthOfPalindromic(s, left - 1, right + 1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
