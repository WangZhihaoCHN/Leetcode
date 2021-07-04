package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.ListNode;

/**
 * 237. 删除链表中的节点  Delete Node in a Linked List
 * <p>
 * 题目描述：
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * 现有一个链表 --head =[4,5,1,9]，它可以表示为:
 * <p>
 * 示例1:
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例2:
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 提示:
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 */
public class DeleteNodeInALinkedList_237 {

    /**
     * 算法思路：
     * 由于只告诉了需要删除的结点，没办法找到前序结点直接连接后序结点，只能换种思路。
     * 由于题目说明，待删除结点非末尾结点。所以只需要将待删除结点val和next指针都替换为后序结点即可，实现逻辑删除
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
       
    }
}
