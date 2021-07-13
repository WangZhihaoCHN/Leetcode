package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.ListNode;

public class OddEvenLinkedList_328 {
    /**
     * 算法思路：
     * 看代码理解即可
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = head, evenHead = head.next;  // 奇、偶数节点头
        ListNode oddPoint = oddHead, evenPoint = evenHead; // 奇、偶遍历节点
        while (evenPoint != null && evenPoint.next != null) {
            oddPoint.next = evenPoint.next;
            oddPoint = oddPoint.next;
            evenPoint.next = oddPoint.next;
            evenPoint = evenPoint.next;
        }
        oddPoint.next = evenHead;
        return oddHead;
    }

}
