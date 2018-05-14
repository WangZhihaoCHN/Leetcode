/* 两数相加 AddTwoNumbers
 *
 * 题目描述：
 *    给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *    输出：7 -> 0 -> 8
 *    原因：342 + 465 = 807
 *
 * */

import java.util.HashMap;

public class Main {
    /*
    * 算法思路：
    *    链表本身是从低位向高位存储，因此按顺序相加即可。通过一个bool保存进位信息，
    * 以完成整个加法过程。
    *
    *  */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 两个链表有一个为空，求和结果为另一个链表
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        // 保存进位信息
        boolean carry = false;
        // 创建返回链表
        ListNode ret = new ListNode(-1);
        ListNode head = ret;

        // 加法过程
        int sum;
        while(l1 != null || l2 !=null){
            sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if(carry)
                sum++;

            if(sum>9){
                carry = true;
                sum = sum%10;
            }else{
                carry = false;
            }

            head.next = new ListNode(sum);
            head = head.next;
        }
        if(carry)
            head.next = new ListNode(1);
        return ret.next;
    }

    public static void main(String[] args) {

    }
}
