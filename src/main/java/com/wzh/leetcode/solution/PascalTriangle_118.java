package com.wzh.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
    /**
     * 算法思路：
     * 模拟生成规则，逐行生成
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        generate(5).forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}
