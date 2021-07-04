package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.ListNode;

/**
 * 206.反转链表  Reverse Linked List
 * <p>
 * 题目描述：
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例1:
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例2:
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例3:
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶：
 * 链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList_206 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, next;
        ListNode current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode newList = reverseList(l1);
        while (newList != null) {
            System.out.print(newList.val);
            newList = newList.next;
        }
    }
}
