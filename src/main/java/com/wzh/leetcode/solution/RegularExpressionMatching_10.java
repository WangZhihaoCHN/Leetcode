package com.wzh.leetcode.solution;

/**
 * 10.正则表达式匹配 Regular Expression Matching
 * <p>
 * 题目描述：
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <p>
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * <p>
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * <p>
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class RegularExpressionMatching_10 {
    /*
     * 算法思路：
     *    递归思想解决，分为以下两种情况：
     * 1) p的第二个字符不是'*'
     *    判断两字符串第一个字符是否匹配（注意：'.'与任何字符都匹配），若匹配，
     * 利用递归球后续部分是否匹配；
     * 2) p的第二个字符是'*'
     *    判断p去掉首两个字符后，后续部分是否与s匹配 —— 对应*匹配前序字符0次
     *    判断两字符串第一个字符是否匹配，匹配则去掉s的首字符，继续递归调用 —— 对应*匹配前序字符多次。
     *
     * 动态规划：
     *    该为动态规划实现，利用一个二维布尔型数组dp，其中dp[i][j]表示s前i个字符和
     * p前j个字符是否匹配，即s[:i] = p[:j]。因此，上述情况可写为：
     * 1) p[j-1]不是*且p[j-1]和s[i-1]成功匹配
     * dp[i][j] = p[j-1]!='*' &&
     *           dp[i-1][j-1] && (
     *                  s[i-1]==p[j-1] ||
     *                  p[j-1]=='.'
     *           );
     * 2) p[j-1]'*'且*作用至少一次或者多次
     * dp[i][j] = p[j-1]=='*' && (
     *                 dp[i][j-2] || (
     *                      dp[i-1][j] &&
     *                      (s[i-1]==p[j-2] || p[j-2]=='.')
     *                 )
     *           );
     *
     *  */
    public static boolean isMatch(String s, String p) {
        // 动态规划数组
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

        /* 初始化阶段 */
        // 空串匹配，dp[0][0]为真
        dp[0][0] = true;
        // 初始化dp数组第0列，除dp[0][0]外，均为假。因为模式串为空，字符串有字符，不可能匹配
        for (int i = 1; i <= s.length(); i++)
            dp[i][0] = false;
        // 初始化dp数组第0行，此时s为空串，只有X*才能匹配，所以如果有*出现，则它的真值一定和p[0][j-2]的相同（略过它之前的符号）
        for (int j = 1; j <= p.length(); j++)
            dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];

        /* 为dp[][]数组赋值阶段 */
        //由于二维数组中是从空串开始的，而字符串中是以0开始的，所以i-1和j-1才对应字符串中的字符。
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                } else {
                    dp[i][j] = j > 1 && (dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')));
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p));
    }
}
