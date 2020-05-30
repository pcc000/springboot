package com.blackfish.java.util.threadLocal;

import java.io.IOException;

/**
 * @Auther: shuyiwei
 * @Date: 2020/5/26 15:49
 * @Description:
 */
public class M {

    public static class  Fdd{
        private byte[] content = new byte[1024*1024*3];

//        @Override
//        protected void finalize() throws Throwable {
//            System.out.println("finalize");
//        }
    }

    public static void main(String[] args) throws Exception {
//        Fdd fdd = new Fdd();
//        System.out.println(fdd);
////        System.gc();
//        Fdd fdd1 = new Fdd();
//        System.out.println(fdd1);
//
//
//        Thread.sleep(1000);
//
//        System.out.println("fdd"+fdd);
//        System.out.println("fdd1"+fdd1);

        for(int i=0 ;i<100;i++){
            Fdd fdd = new Fdd();
            System.gc();
            Thread.sleep(1000);
            System.out.println(fdd);
        }


        System.in.read();
    }
}
