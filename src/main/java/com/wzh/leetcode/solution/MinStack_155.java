package com.wzh.leetcode.solution;

import java.util.Stack;

public class MinStack_155 {
    /**
     * 算法思路：
     * 使用辅助栈。主栈用来压入元素，辅助栈同步压入最小值，弹出时同步弹出即可。
     * <p>
     * 拓展：避免使用辅助栈的方法。
     * 每次不直接压入元素，而是压入当前元素与最小值的差值。
     * 当弹出时，如果遇到负数，意味着最小值需要更新了。
     * 注：注意top()函数
     */

    private Stack<Long> stack;
    private long minValue;

    /**
     * initialize your data structure here.
     */
    public MinStack_155() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            // 第一个元素为最小值，且压入与最小值的差值0
            minValue = val;
            stack.push(0L);
        } else {
            // 其他，直接压入差值即可
            stack.push(val - minValue);
            // 最小值是否需要更新
            minValue = Math.min(val, minValue);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        Long value = stack.pop();
        if (value < 0) {
            minValue -= value;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            //栈顶元素如果是正的，说明栈顶元素压栈的时候是比栈中最小值大的，根据
            //top=x - min，可以计算x=top+min
            return (int) (top + minValue);
        } else {
            // 当栈顶元素是负数的时候，说明栈顶元素压栈的时候是比栈中最小值小的，
            // 而压栈完之后他会更新最小值min，所以如果在使用上面公式肯定是不行的。
            // 如果栈顶元素压栈的时候比最小值小，他会更新最小值，这个最小值
            // 就是我们要压栈的值，所以这里直接返回min就行了。
            return (int) (minValue);
        }
    }

    public int getMin() {
        return (int) minValue;
    }

    public static void main(String[] args) {
        MinStack_155 obj = new MinStack_155();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
