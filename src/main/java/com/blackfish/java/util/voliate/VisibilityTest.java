package com.blackfish.java.util.voliate;

/**
 * @Auther: shuyiwei
 * @Date: 2019/9/29 20:08
 * @Description:
 */
public class VisibilityTest {

    private static boolean is =true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(VisibilityTest.is){
                    i++;
                }
                System.out.println(i);
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        VisibilityTest.is = false;
        System.out.println("set false");
    }
}


