package com.wzh.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {
    /**
     * 算法思路：
     * 直接整除
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String num = "";
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);
            if (divisibleBy3) {
                num += "Fizz";
            }
            if (divisibleBy5) {
                num += "Buzz";
            }
            if (num.equals("")) {
                num = Integer.toString(i);
            }
            result.add(num);
        }
        return result;
    }
}
