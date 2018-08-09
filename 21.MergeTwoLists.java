/* 21. 合并两个有序链表 Merge Two Sorted Lists
 *
 * 题目描述：
 *    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * */


public class Main {
    /*
     * 算法思路：
     *
     *
     *  */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 异常输入
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = new ListNode(0);

        ListNode pNow = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pNow.next = l1;
                pNow = pNow.next;
                l1 = l1.next;
            } else {
                pNow.next = l2;
                pNow = pNow.next;
                l2 = l2.next;
            }
        }

        if (l1 != null)
            pNow.next = l1;
        else
            pNow.next = l2;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        r1.next = r2;
        r2.next = r3;
        ListNode result = mergeTwoLists(l1, r1);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
