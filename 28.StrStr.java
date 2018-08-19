/* 28. 实现strStr() Implement strStr()
 *
 * 题目描述：
 *    实现strStr()函数。
 * 给定一个haystack字符串和一个needle字符串，在haystack字符串中
 * 找出needle字符串出现的第一个位置(从0开始)。如果不存在，则返回-1。
 *
 * 示例 1:
 * 输入: haystack="hello", needle="ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack="aaaaa", needle="bba"
 * 输出: -1
 *
 * 说明:
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回0。这与C语言的strStr()
 * 以及Java的indexOf()定义相符。
 *
 * */

public class Main {
    /*
     * 算法思路：
     * 1. 简单思路
     *    首先要做一些判断，如果子字符串为空，则返回0。
     * 如果子字符串长度大于母字符串长度，则返回-1。然后
     * 我们开始遍历母字符串，我们并不需要遍历整个母字符
     * 串，而是遍历到剩下的长度和子字符串相等的位置即可，
     * 这样可以提高运算效率。然后对于每一个字符，我们都
     * 遍历一遍子字符串，一个一个字符的对应比较，如果对应
     * 位置有不等的，则跳出循环，如果一直都没有跳出循环，
     * 则说明子字符串出现了，则返回起始位置即可。
     *
     * 2. kmp算法
     * 参考链接：
     * https://www.cnblogs.com/zhangtianq/p/5839909.html
     * https://blog.csdn.net/liu940204/article/details/51318281
     *
     *  */
    public static int strStr(String haystack, String needle) {
        // 异常输入
        if (needle==null || needle.length()==0)
            return 0;
        if (haystack==null || haystack.length()==0 || haystack.length()<needle.length())
            return -1;

        // 求kmp算法的next数组
        int next[] = new int[needle.length()+1];
        next[0] = -1;
        int k=-1, j=0;
        while (j < needle.length()-1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }

        // 利用next数组找第一次匹配的位置
        int i=0;
        j=0;
        while (i<haystack.length() && j<needle.length()) {
            if (j==-1 || haystack.charAt(i)==needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        // 返回结果
        if (j == needle.length())
            return i-j;
        else
            return -1;
    }

    public static void main(String[] args) {
        String haystack="aaaaa", needle="bba";
        System.out.println(strStr(haystack, needle));
    }
}
