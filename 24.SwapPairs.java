/* 24. 两两交换链表中的节点 Swap Nodes in Pairs
 *
 * 题目描述：
 *    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 说明:
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * */


public class Main {
    /*
     * 算法思路：
     *    链表操作，画图
     *
     *  */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pHead, p, pL, pR;
        p = head;
        pHead = p.next;
        while (true) {
            pL = p;
            pR = pL.next;
            p = p.next.next;
            pR.next = pL;
            // 判断退出条件，包含了共有奇数/偶数个结点的情况
            if (p == null || p.next == null) {
                pL.next = p;
                break;
            }
            pL.next = p.next;
        }
        return pHead;
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
        ListNode result = swapPairs(n1);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
