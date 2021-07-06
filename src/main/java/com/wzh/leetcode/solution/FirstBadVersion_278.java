package com.wzh.leetcode.solution;

public class FirstBadVersion_278 {
    /**
     * 算法思路：
     * 二分查找
     */
    public int firstBadVersion(int n) {
        return firstBadVersionHelper(1, n);
    }

    private int firstBadVersionHelper(int begin, int end) {
        if (begin == end) {
            return begin;
        }
        int mid = begin + (end - begin) / 2;
        if (isBadVersion(mid)) {
            return firstBadVersionHelper(begin, mid);
        } else {
            return firstBadVersionHelper(mid + 1, end);
        }
    }

    private boolean isBadVersion(int version) {
        return false;
    }
}
