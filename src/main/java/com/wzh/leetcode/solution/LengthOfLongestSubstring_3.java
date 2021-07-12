package com.wzh.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
     *
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

    /**
     * 算法思路：
     * 滑动窗口
     * 一左一右两个指针标识子串的左右边界，左指针向右移动一格，
     * 表示我们开始枚举以下一个字符为起始点的最长子串，此时，
     * 右指针不断向右移动，直到出现重复字符则停止。
     * 我们可以用hash set存储左右指针之间的字符，当左指针向后移动，
     * 从set中移除一个字符，当右指针向后移动，往set中添加一个字符。
     */
    public static int lengthOfLongestSubstringV2(String s) {
        // 当前子串字符集
        Set<Character> hashSet = new HashSet<>();
        // 初始化右指针
        int ans = 0;
        for (int left = 0, right = 0; left < s.length(); left++) {
            // 左指针后移，hash set中移除一个元素
            if (left != 0) {
                hashSet.remove(s.charAt(left - 1));
            }
            // 右指针不断后移，如果hash set中不存在，添加元素到set中
            while (right < s.length() && !hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                right++;
            }
            // 判断当前子串是否更长
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringV2("dvdf"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstringV2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstringV2("pwwkew"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
