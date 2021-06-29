package com.wzh.leetcode.solution;

/**
 * 125. 验证回文串  Valid Palindrome
 * <p>
 * 题目描述：
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例2:
 * 输入: "race a car"
 * 输出: false
 */
public class ValidPalindrome_125 {

    public static boolean isPalindrome(String s) {
        char[] a = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(a[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(a[right])) {
                right--;
            } else if (Character.toLowerCase(a[left]) != Character.toLowerCase(a[right])) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
