/* 27. 移除元素 Remove Element
 *
 * 题目描述：
 *    给定一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，
 * 返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入
 * 数组并在使用O(1)额外空间的条件下完成。元素的顺序可以改变。你不需要考虑
 * 数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * */

public class Main {
    /*
     * 算法思路：
     *     利用一前一后两个指针，后指针last从后向前找到第一个不是
     * val值的元素，前指针pre从前往后扫描数组找到第一个是val值的元素，
     * 找到后交换两个元素，继续进行上述步骤。直到两指针相遇或交错，
     * 算法结束。
     *
     *  */
    public static int removeElement(int[] nums, int val) {
        int pre = 0, last = nums.length-1;
        int count = 0;
        while (true) {
            while (last>=0 && nums[last] == val)
                last--;
            while (pre<last && nums[pre] != val) {
                pre++;
                count++;
            }
            if (pre > last)
                break;
            count++;
            nums[pre] = nums[last];
            pre++;
            last--;
        }
        return count;
    }


    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,0,4,2};
        int count = removeElement(nums, 2);
        for (int i=0; i<count; i++)
            System.out.print(nums[i]+" ");
    }
}
