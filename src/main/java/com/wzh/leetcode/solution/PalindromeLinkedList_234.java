package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表  Palindrome Linked List
 * <p>
 * 题目描述：
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList_234 {
    /**
     * 算法思路：
     * 将链表数字转存到数组中，然后双指针法进行判断
     * <p>
     * 进阶思路：
     * 找到中点，翻转后半部分链表，判断后，翻转恢复后半段
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }

        int left = 0, right = array.size() - 1;
        while (left < right) {
            if (array.get(left) != array.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
