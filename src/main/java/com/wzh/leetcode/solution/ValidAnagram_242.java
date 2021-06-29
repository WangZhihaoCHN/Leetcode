package com.wzh.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词  Valid Anagram
 * <p>
 * 题目描述：
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class ValidAnagram_242 {
    /**
     * 算法思路：
     * Hash表存储字符和数量
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            int count = map.getOrDefault(ch, 0);
            if (count == 0) {
                return false;
            }
            map.put(ch, count - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
