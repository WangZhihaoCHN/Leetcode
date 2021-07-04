package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree_98 {
    /**
     * 算法思路：
     * 思路1：中序遍历，值递增
     * 思路2：递归函数，helper(root, lower, upper)，表示以root为根的子树，
     * 所有节点的范围都在(lower, upper)开区间内，遍历左子树时将upper设置为根节点的值，
     * 遍历右子树时，将lower设置为根节点的值，初始调用时上下界为正负无穷。
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long preOrderValue = Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= preOrderValue) {
                return false;
            }
            preOrderValue = root.val;
            root = root.right;
        }
        return true;
    }
}
