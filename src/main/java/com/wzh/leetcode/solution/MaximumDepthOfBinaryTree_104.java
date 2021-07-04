package com.wzh.leetcode.solution;

import com.wzh.leetcode.dto.TreeNode;

public class MaximumDepthOfBinaryTree_104 {
    /**
     * 算法思路：
     * 递归，深度优先遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
