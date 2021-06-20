package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.ListNode;

/**
 * 2.两数相加 AddTwoNumbers
 * <p>
 * 题目描述：
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers_2 {
    /*
     * 算法思路：
     *    链表本身是从低位向高位存储，因此按顺序相加即可。通过一个bool保存进位信息，
     * 以完成整个加法过程。
     *
     *    可以通过两个指针，分别指向两个链表，不断地同时向后移，并计算对应位相加、
     * 上一位进位以及是否产生进位等。当某一链表指针已经移动到最后，则该计算时忽略该
     * 链表。当两个链表都移动到最后一位，则跳出循环，计算完毕。
     *
     *  */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 两个链表有一个为空，求和结果为另一个链表
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // 保存进位信息
        boolean carry = false;
        // 创建返回链表
        ListNode ret = new ListNode(-1);
        ListNode head = ret;

        // 加法过程
        int sum;
        while (l1 != null || l2 != null) {
            // 当前位相加的和初始化
            sum = 0;
            // 防止l1和l2不存在当前位的情况
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // 进位信息
            if (carry)
                sum++;

            // 是否产生进位
            if (sum > 9) {
                carry = true;
                sum = sum % 10;
            } else {
                carry = false;
            }

            // 将求和的值保存到下一个节点
            head.next = new ListNode(sum);
            head = head.next;
        }
        // 判断最后会不会产生一个最高位的进位
        if (carry)
            head.next = new ListNode(1);
        // 头结点中无信息，跳过该结点
        return ret.next;
    }

    public static void main(String[] args) {

    }
}
