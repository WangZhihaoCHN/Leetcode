package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.ListNode;

/**
 * 25. k个一组翻转链表 Reverse Nodes in k-Group
 * <p>
 * 题目描述：
 * 给出一个链表，每k个节点一组进行翻转，并返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。如果节点总数不是
 * k的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例:
 * 给定这个链表：1->2->3->4->5
 * 当k=2时，应当返回:2->1->4->3->5
 * 当k=3时，应当返回:3->2->1->4->5
 * <p>
 * 说明:
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReverseNodesInKGroup_25 {
    /*
     * 算法思路：
     *    将整个过程分为两步：
     *    1.一前pre一后next两个指针，后指针next每次比pre指向的结点多走
     *  k步，如果next没有到达链表尾部，则进行步骤2。否则，算法结束；
     *    2.通过一个方法，将pre和next之间的链表部分，进行反转。
     *
     *  */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;

        // 创建伪头结点
        ListNode pHead = new ListNode(0);
        pHead.next = head;

        ListNode pNext = head, pre = pHead;
        int count = 0;
        while (pNext != null) {
            pNext = pNext.next;
            count++;
            if (count == k) {
                count = 0;
                pre = reverseLinklist(pre, pNext);
                pNext = pre.next;
                continue;
            }
        }
        return pHead.next;
    }

    /*
     *  翻转pre指针到next指针之间的链表部分，返回翻转结束后pre指针指向的结点。
     *
     *  示例:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * pre        next
     *
     * after call pre = reverse(pre, next)
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     * */
    public static ListNode reverseLinklist(ListNode pre, ListNode pNext) {
        // 异常输入
        if (pre == pNext)
            return pre;
        ListNode head = pre;
        ListNode last = pre.next;   // 保存翻转后的最后一个结点
        ListNode pL = pre, pR;
        pre = pre.next;
        while (pre != pNext) {
            pR = pre;
            pre = pre.next;
            pR.next = pL;
            pL = pR;
        }
        head.next = pL;
        last.next = pNext;
        return last;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode result = reverseKGroup(n1, 2);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
