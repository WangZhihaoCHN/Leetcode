package com.wzh.leetcode.solution;


import com.wzh.leetcode.dto.ListNode;

/**
 * 19.删除链表的倒数第N个节点 Remove Nth Node From End of List
 * <p>
 * 题目描述：
 * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗
 */
public class RemoveNthNodeFromEndOfList_19 {
    /*
     * 算法思路：
     *    一个快指针首先指向头结点的往后的第n个结点，
     * 之后头指针和快指针同步后移，直到快指针到达链表
     * 尾部。当前头指针指向结点，即为待删除结点。
     *
     *  */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 异常输入判断
        if (head == null || n < 0)
            return null;
        ListNode tail, before, first;
        before = tail = first = head;
        for (int i = 0; i < n; i++) {
            if (tail == null)
                return head;
            tail = tail.next;
        }
        while (tail != null) {
            before = first;
            first = first.next;
            tail = tail.next;
        }
        // 要删除的是头结点
        if (first == head)
            return first.next;
        // 删除对应节点
        before.next = first.next;
        return head;
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
        ListNode result = removeNthFromEnd(n1, 2);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
