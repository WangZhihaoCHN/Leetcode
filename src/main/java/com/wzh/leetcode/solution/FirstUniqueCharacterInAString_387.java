package com.wzh.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符  First Unique Character in a String
 * <p>
 * 题目描述：
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例1:
 * s = "leetcode"
 * 返回 0
 * <p>
 * 示例2:
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class FirstUniqueCharacterInAString_387 {
    /**
     * 算法思路：
     * 遍历数组两边，第一遍统计字符出现次数，第二遍找出索引
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
