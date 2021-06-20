package com.wzh.leetcode.solution;

import java.util.HashMap;

/**
 * 3.无重复字符的最长子串 LengthOfLongestSubstring
 * <p>
 * 题目描述：
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是子序列，而不是子串。
 */
public class LengthOfLongestSubstring_3 {
    /*
     * 算法思路：
     *    利用一前一后两个指针(start,end)，后指针依次扫描字符串中的元素。
     * 当end遇到和之前重复的字符时(记前一次出现的下标为Occur1, 本次出现的下标为Occur2)，
     * 即遇到了一个可能的最大值，将其与之前的最大值进行比较，记录保存较大者。
     * 将下一次扫描的起点设置为Occur1的后一位即可。
     *    其中，判断元素是否重复出现并获取其下标，可以通过hashmap实现。而出现重复
     * 元素后，新起点的选取点则是本题关键。
     *
     *  */
    public static int lengthOfLongestSubstring(String s) {
        // 异常输入
        if (s == null || s.length() == 0)
            return 0;

        // 哈希表判断重复元素与其下标位置
        HashMap<Character, Integer> map = new HashMap<>();

        // 一前一后两个指针，以及全局最大子串长度
        int start = 0, end = 0;
        int maxLength = 0;
        // 后指针直到结尾时，寻找完毕
        while (end < s.length()) {
            // 当前end指向的元素，之前没有出现，将新元素放入哈希表中，end指针继续移动
            // 或者，当前元素有重复的，但是不在start到end的范围内，只需要更新相应下标即可
            if (!map.containsKey(s.charAt(end)) || map.get(s.charAt(end)) < start) {
                map.put(s.charAt(end), end);
            } else {
                if (end - start > maxLength)
                    maxLength = end - start;
                start = map.get(s.charAt(end)) + 1;
                // 更新相应重复元素的下标值
                map.put(s.charAt(end), end);
            }
            end++;
        }
        // 防止最后一部分或者整个字符串都没有重复字符出现
        if (end - start > maxLength)
            maxLength = end - start;
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("c"));
    }
}
