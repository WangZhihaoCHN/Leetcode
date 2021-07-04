package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.TreeNode;

public class SymmetricTree_101 {
    /**
     * 算法思路：
     * 两个指针同时遍历左、右子树，保证左子树的右节点等于右子树的左节点，相反依然
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val
                    && isSymmetricHelper(left.left, right.right)
                    && isSymmetricHelper(left.right, right.left);
        }
    }
}
