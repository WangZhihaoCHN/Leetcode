package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.TreeNode;
import com.wzh.leetcode.utils.TreeTraversalUtil;

public class ConvertSortedArrayToBinarySearchTree_108 {
    /**
     * 算法思路：
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, begin, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        ConvertSortedArrayToBinarySearchTree_108 solution = new ConvertSortedArrayToBinarySearchTree_108();
        TreeNode node = solution.sortedArrayToBST(nums);
        TreeTraversalUtil.inorderRecursion(node);
    }
}
