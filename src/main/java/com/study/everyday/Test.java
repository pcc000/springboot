package com.study.everyday;

public class Test {

    public static void main(String[] args) {
        int[][] cells = new int[2][2];
        cells[0][0] = 1;
        cells[0][1] = 2;
        cells[1][0] = 3;
        cells[1][1] = 1;

        for(int[] i : cells){
            System.out.println(i[0] +","+i[1]);
        }


    }

    /**
     * 奇数值单元格的数目
     * https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
     * @param m
     * @param n
     * @param indices
     * @return
     */
    public int oddCells(int m, int n, int[][] indices) {
        int[][] cells = new int[m][n];
        for(int[] row : indices){
//            cells[]
        }

        return 0;
    }
}
