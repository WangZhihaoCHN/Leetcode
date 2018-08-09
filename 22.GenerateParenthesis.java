/* 22. 括号生成 Generate Parentheses
 *
 * 题目描述：
 *    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * */


import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
     * 算法思路：
     *    递归的思想
     *    由于字符串只有左括号和右括号两种字符，而且最终结果必定是左括号n个，右括号n个.
     * 所以我们定义两个变量left和right分别表示剩余左右括号的个数，如果在某次递归时，
     * 左括号的个数大于右括号的个数，说明此时生成的字符串中右括号的个数大于左括号的个数，
     * 即会出现')('这样的非法串，所以这种情况直接返回，不继续处理。如果left和right都为0，
     * 则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回。
     * 如果以上两种情况都不满足，若此时left大于0，则调用递归函数，注意参数的更新，
     * 若right大于0，则调用递归函数，同样要更新参数。
     *
     *  */
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        myGenerateParenthesis(result,sb,n,n);
        return result;
    }

    /*
    * Params:
    * res:   返回结果
    * sb:    当前递归步中由括号构成的字符串
    * left:  左括号剩余数量
    * right: 右括号剩余数量
    * */
    public static void myGenerateParenthesis(
            ArrayList<String> res, StringBuilder sb, int left, int right){
        // 递归结束条件，全都放置完毕
        if (left==0 && right==0) {
            res.add(sb.toString());
            return;
        }

        if (left == 0){             // 只剩余右括号
            sb.append(')');
            myGenerateParenthesis(res,sb,left,right-1);
            sb.deleteCharAt(sb.length()-1);
        }else if (left == right) {  // 相当于初始情况，只能用左括号
            sb.append('(');
            myGenerateParenthesis(res,sb,left-1,right);
            sb.deleteCharAt(sb.length()-1);
        } else {                    // 右括号数量多于左括号，此时放什么都可以
            sb.append('(');
            myGenerateParenthesis(res,sb,left-1,right);
            sb.deleteCharAt(sb.length()-1);
            sb.append(')');
            myGenerateParenthesis(res,sb,left,right-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String tmp : list)
            System.out.println(tmp);
    }
}
