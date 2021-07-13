package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.ListNode;

public class IntersectionOfTwoLinkedLists_160 {
    /**
     * 算法思路：
     * 1.哈希集合
     * 遍历链表headA，将节点放入集合。在遍历链表headB，判断是否在集合中
     * <p>
     * 2.双指针(进阶解法)
     * 双指针headA、B同时遍历，若一方先到null，则调到对方的头部继续遍历，
     * 直到相遇或均为null
     * 解释：考虑A距离相交点为m个，B距离相交点为n个，相交之有公共元素x个。
     * 讨论m>n，则B遍历完走了n+x步，此时A未走完，过程中不会相遇，B跳转到A的起始位置继续。
     * 走了m+x步之后，A到达结尾，此时B从A的起点走了m-n步，小于m步不会到达公共点。然后，
     * A跳转到B开头，再走n步后，两者相遇。
     * 其他情况类似讨论。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointA = headA, pointB = headB;
        while (pointA != pointB) {
            pointA = pointA == null ? headB : pointA.next;
            pointB = pointB == null ? headA : pointB.next;
        }
        return pointA;
    }
}
