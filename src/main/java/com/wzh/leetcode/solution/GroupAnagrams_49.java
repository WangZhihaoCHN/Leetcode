package com.wzh.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
    /**
     * 算法思路：
     * 需要一个哈希表存储key和该组内的字母易位词。
     * 还需要一个将字母易位词计算得到同一个key的算式。
     * <p>
     * 后者算式可以为：
     * 对一个单词的字母排序
     * 也可以用26维的int数组记录每个字母的次数
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            // 每个单词申请一个哈希表，存储每个字母出现的次数
            int[] letterCount = new int[26];
            for (int i = 0; i < str.length(); i++) {
                letterCount[str.charAt(i) - 'a']++;
            }
            // 唯一key算式：将字符串中的字母+次数拼接形成key
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < letterCount.length; i++) {
                if (letterCount[i] != 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(letterCount[i]);
                }
            }
            String key = sb.toString();
            List<String> value = hashMap.getOrDefault(key, new ArrayList<>());
            value.add(str);
            hashMap.put(key, value);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> tmp : result) {
            for (String str : tmp)
                System.out.print(str + " ");
            System.out.println();
        }
    }
}
