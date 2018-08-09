/* 23. 合并K个排序链表 Merge k Sorted Lists
 *
 * 题目描述：
 *    合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * */


import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    /*
     * 算法思路：
     *    维护一个大小为k的堆，每次取堆顶的最小元素放到结果中，
     * 然后读取该元素的下一个元素放入堆中，重新维护好。因为每个
     * 链表是有序的，每次又是去当前k个元素中最小的，所以当所有
     * 链表都读完时结束，这个时候所有元素按从小到大放在结果链表
     * 中。这个算法每个元素要读取一次，即是k*n次，然后每次读取
     * 元素要把新元素插入堆中要logk的复杂度，所以总时间复杂度
     * 是O(nklogk)。空间复杂度是堆的大小，即为O(k)。
     *
     *  */
    public static ListNode mergeKLists(ListNode[] lists) {
        // 申请一个最小堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        // 将所有链表头加入小根堆
        for (ListNode i:lists) {
            if (i != null)
                heap.add(i);
        }
        // 依次从小根堆中取出最小的结点连接起来
        ListNode head = new ListNode(0);
        ListNode pNow = head, tmp;
        while (!heap.isEmpty()) {
            tmp = heap.poll();
            pNow.next = tmp;
            pNow = pNow.next;
            tmp = tmp.next;
            if (tmp != null)
                heap.add(tmp);
        }
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
        ListNode list[] = {l1,r1};
        ListNode result = mergeKLists(list);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
