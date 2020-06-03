package com.blackfish.java.suanfa;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/2 16:02
 * @Description:
 *
 * 面试题64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumNums {
    public int sumNums(int n) {
        return   n == 1 ? 1 : n+sumNums(n-1);
    }

    public int sumNums2(int n) {
        boolean s = n>=1 && (n=n+sumNums2(n-1))>0;
        return n;
    }

    public static void main(String[] args) {
        SumNums sumNums = new SumNums();
        System.out.println(sumNums.sumNums(9));

        System.out.println(sumNums.sumNums2(9));
    }
}
