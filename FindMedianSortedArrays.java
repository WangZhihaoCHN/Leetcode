/* 两个排序数组的中位数 findMedianSortedArrays
 *
 * 题目描述：
 *    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *    请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 *
 * 示例 1:
 *    nums1 = [1, 3]
 *    nums2 = [2]
 *    中位数是 2.0
 *
 * 示例 2:
 *    nums1 = [1, 2]
 *    nums2 = [3, 4]
 *    中位数是 (2 + 3)/2 = 2.5
 *
 * */

public class Main {
    /*
    * 算法思路：
    *    1. 传统思路 线性复杂度O(m+n)
    *    其实我们只是要找出第k大的数，所以只需要排序前面k个数，不用排完所有数。
    * 可以使用类似与merge sort的方法，设置两个指针Pa、Pb和一个计数变量num，
    * Pa和Pb分别指向数组A和B的首位，比较二者，较小的就输出，并且指针往前移一位，
    * num++；再比较二者，小的输出......如此迭代进行，直到num==k。
    * 这种方法时间复杂度是O(k)；【对本题来说为O（（m+n）/2）即O(m+n)】
    *
    *    2. O(log(m+n))方法
    *    要找到A和B数组中第k大的数，可以比较A[k/2-1]以及B[k/2-1]，假如A[k/2-1]比较小，
    * 则说明A[0]~A[k/2-1]都小于第k大的数，删除这k/2个数，得到新的A'。接下来，问题转化为
    * 求A'和B中第k/2大的数........如此循环直到k/2=1。由 k/2^n=1推算得这个方法的
    * 复杂度是O(logk)。【对本题来说是O(log(m+n))】
    *
    * 注意!!!!需要注意的是，A或者B的个数不一定有k/2个，比如m<k/2时，
    * 作为比较的数据应该是A[m]和B[k-m]，即满足[]内两个数加起来的和为k。
    *
    *  */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 分奇偶两种情况
        int lengthA = nums1.length;
        int lengthB = nums2.length;
        if ((lengthA + lengthB) % 2 == 0) {
            double r1 = (double) myFindMedianSortedArrays(nums1, 0, lengthA, nums2, 0, lengthB, (lengthA + lengthB) / 2);
            double r2 = (double) myFindMedianSortedArrays(nums1, 0, lengthA, nums2, 0, lengthB, (lengthA + lengthB) / 2 + 1);
            return (r1 + r2) / 2;
        } else
            return myFindMedianSortedArrays(nums1, 0, lengthA, nums2, 0, lengthB, (lengthA + lengthB + 1) / 2);
    }

    // 求两个有序数组num1和num2的第k大元素
    public static int myFindMedianSortedArrays(int A[], int startA, int endA, int B[], int startB, int endB, int k) {
        // 计算两个数组剩余部分的长度
        int n = endA - startA;
        int m = endB - startB;

        // 当有个数组已经删除完所有元素，第k大的数就是另一数组相应位置之后的第k个数
        if (n <= 0)
            return B[startB + k - 1];
        if (m <= 0)
            return A[startA + k - 1];

        // 递归终止条件，因为k=1不可二分了，此时较小者即为第k位数
        if (k == 1)
            return A[startA] < B[startB] ? A[startA] : B[startB];

        // 计算两数组的中位值
        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;

        // 特殊情况，有一个数组剩余元素不到k/2个时
        // 考虑num1满，即没有剩余元素，此时num2需要再向后移动一点补全缺少部分，
        // 使得两数组前k/2部分拼后总数为k。显然此时num1中位置在最后了。
        if (A[midA] <= B[midB]) {
            if (n / 2 + m / 2 + 1 >= k)
                return myFindMedianSortedArrays(A, startA, endA, B, startB, midB, k);
            else
                return myFindMedianSortedArrays(A, midA + 1, endA, B, startB, endB, k - n / 2 - 1);
        } else {
            if (n / 2 + m / 2 + 1 >= k)
                return myFindMedianSortedArrays(A, startA, midA, B, startB, endB, k);
            else
                return myFindMedianSortedArrays(A, startA, endA, B, midB + 1, endB, k - m / 2 - 1);
        }
    }

    public static void main(String[] str) {
        int A[] = {1,2};
        int B[] = {3,4};
        double ret = findMedianSortedArrays(A, B);
        System.out.println(ret);
    }
}
