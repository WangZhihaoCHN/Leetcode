package com.wzh.leetcode.utils;

import com.wzh.leetcode.dto.TreeNode;

import java.util.Stack;

public class TreeTraversalUtil {
    /**
     * 先序遍历（迭代版)
     */
    public static void preOrderIteration(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 先序遍历（递归版)
     */
    public static void preOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    /**
     * 中序遍历（迭代版）
     */
    public static void inorderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    /**
     * 中序遍历（递归版）
     */
    public static void inorderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderRecursion(root.left);
        System.out.print(root.val + " ");
        inorderRecursion(root.right);
    }

    /**
     * 后序遍历（迭代版)
     * <p>
     * 遍历到左子树最左节点，并将沿途节点入栈，直到左子树无路可走
     * 不同于中序遍历，需要试探顶节点是否能弹出栈，如果不能出栈，则将右子树入栈
     * - 当顶节点无右子树时，可弹出
     * - 当顶节点右子树已遍历过时，可弹出。注意后续遍历，root节点必定会紧挨着其孩子节点后输出。
     */
    public static void postorderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == preNode) {
                preNode = stack.pop();
                System.out.print(preNode.val + " ");
                root = null;
            } else {
                root = root.right;
            }
        }
    }

    /**
     * 后序遍历（递归版)
     */
    public static void postorderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderRecursion(root.left);
        postorderRecursion(root.right);
        System.out.print(root.val + " ");
    }
}
