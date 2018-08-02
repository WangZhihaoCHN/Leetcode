/* Z字形变换 ZigZag Conversion
 *
 * 题目描述：
 *    将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * 实现一个将字符串进行指定行数变换的函数:
 * string convert(string s, int numRows);
 *
 * 示例1：
 *    输入: s = "PAYPALISHIRING", numRows = 3
 *    输出: "PAHNAPLSIIGYIR"
 *
 * 示例2：
 *    输入: s = "PAYPALISHIRING", numRows = 4
 *    输出: "PINALSIGYAHRPI"
 *    解释:
 *    P     I    N
 *    A   L S  I G
 *    Y A   H R
 *    P     I
 * */

public class Main {
    /*
     * 算法思路：
     *    首先找规律，Z字形排列是有多个子结构(一条垂直数线+斜向上线)构成，
     * 且首行和末行只有一个元素，其他行为两个元素。每个子结构一共包含有
     * 2*numRows-2 个元素，因此每个子结构的首元素，即左上角元素下标可求。
     * 同理，每个子结构的垂直线上的元素下标以此加所在行号即可得。而位于斜线上
     * 的第二个元素下标，通过找规律发现，是首元素+子结构元素总数-行号。
     *    综上，只需要遍历所有行，首先计算子结构首元素下标，之后依次计算当前
     * 行第一个元素和(如果有的话）第二个元素，即可得最终答案。
     *
     *  */
    public static String convert(String s, int numRows) {
        public static String convert(String s, int numRows) {
            // 异常输入
            if (s == null || s.length() == 0 || numRows <= 0)
                return "";
            
            if (numRows == 1)
                return s;
            
            int index;          // 每个子结构的首字母在字符串中的索引
            int length = s.length();
            StringBuilder res = new StringBuilder();
            for (int i=0; i<numRows; i++){
                index = 0;
                while (true){
                    if (index+i < length)
                        res.append(s.charAt(index+i));
                    // 如果当前行不是第一行或最后一行，应该有第二个元素
                    if (i != 0 && i != numRows-1){
                        int next = index+2*numRows-2-i;
                        if (next < length)
                            res.append(s.charAt(next));
                    }
                    index += 2*numRows-2;
                    if (index >= length)
                        break;
                }
            }
            return res.toString();
        }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
