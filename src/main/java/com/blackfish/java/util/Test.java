package com.blackfish.java.util;

import java.util.Random;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/20 11:00
 * @Description:
 */
public class Test {

    final static char[] digits = {'0', '1'};

    static String toBinaryString(int i) {
        char[] buf = new char[32];
        int pos = 32;
        int mask = 1;
        do {
            buf[--pos] = digits[i & mask];
            i >>>= 1;
        } while (pos > 0);
        return new String(buf, pos, 32);
    }

    public static void main(String[] args) {
//        final int max = Integer.MAX_VALUE >>> 4;
//        Random random = new Random(System.currentTimeMillis());
//        for (int i = 0; i < 20; i++) {
//            int hash = random.nextInt(max) << 4;
//            int betterHash = hash ^ (hash >>> 16);
//            System.out.print(toBinaryString(hash));
//            System.out.println("-->" + toBinaryString(betterHash));
//        }
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(-3>>>16));
        System.out.println(Integer.toBinaryString(-3^(-3>>>16)));

        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(3>>>16));
        System.out.println(Integer.toBinaryString(3^(3>>>16)));

        System.out.println(Integer.toBinaryString(1048500));
        System.out.println(Integer.toBinaryString(1048500>>>16));
        System.out.println(Integer.toBinaryString(1048500^(1048500>>>16)));
    }
}
