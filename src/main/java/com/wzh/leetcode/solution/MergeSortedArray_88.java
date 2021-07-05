package com.wzh.leetcode.solution;

public class MergeSortedArray_88 {
    /**
     * 算法思路：
     * 显然，参考归并排序思想，使用双指针法可解，但需要额外的m+n空间，以避免元素覆盖
     * 转变思想：由于nums1数组后半部分为空，只需要从后向前填充，则不会产生覆盖
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int left = m - 1;
        int right = n - 1;
        while (left >= 0 || right >= 0) {
            if (left < 0) {
                nums1[index--] = nums2[right--];
            } else if (right < 0) {
                nums1[index--] = nums1[left--];
            } else if (nums1[left] < nums2[right]) {
                nums1[index--] = nums2[right--];
            } else {
                nums1[index--] = nums1[left--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.print(num);
        }
    }
}
