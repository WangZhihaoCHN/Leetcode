/* 盛最多水的容器 Container With Most Water
 *
 * 题目描述：
 *    给定n个非负整数a1,a2,...,an,每个数代表坐标中的
 * 一个点(i,ai)。在坐标内画n条垂直线，垂直线i的两个端点
 * 分别为(i,ai)和(i,0)。找出其中的两条线，使得它们与x轴
 * 共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且n的值至少为2。
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * */

public class Main {
    /*
     * 算法思路：
     *    最初我们考虑由最外围两条线段构成的区域。现在，为了使面积最大化，
     * 我们需要考虑更长的两条线段之间的区域。如果我们试图将指向较长线段的
     * 指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。
     * 但是，在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的
     * 减小，但却可能会有助于面积的增大。因为移动较短线段的指针会得到一条
     * 相对较长的线段，这可以克服由宽度减小而引起的面积减小。
     *
     * 双指针法
     *    我们在由线段长度构成的数组中使用两个指针，一个放在开始，
     * 一个置于末尾。 此外，我们会使用变量maxarea来持续存储到目前
     * 为止所获得的最大面积。 在每一步中，我们会找出指针所指向的
     * 两条线段形成的区域，更新 maxarea，并将指向较短线段的指针向
     * 较长线段那端移动一步。
     *
     *  */
    public static int maxArea(int[] height) {
        int maxarea = 0;
        int head = 0, tail = height.length-1;
        while (tail-head>0){
            maxarea = Math.max(maxarea, (tail-head)*Math.min(height[head],height[tail]));
            if (height[head]<height[tail])
                head++;
            else
                tail--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int input[]= {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));
    }
}