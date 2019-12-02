package com.blackfish.java.suanfa;

public class Reverse {

    public int reverse(int x) {
        if(x==0){
            return 0;

        }
        String str = String.valueOf(Math.abs(x));
        char c[] = str.toCharArray();
        boolean firstIsZero = true;
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = c.length-1;i>=0;i--){
            if(c[i]!='0'){
                firstIsZero = false;
            }
            if(!firstIsZero){
                stringBuffer.append(c[i]);
            }
        }
        long result = Long.valueOf(stringBuffer.toString());

        if(result>2147483647 || result<-2147483646){
            return 0;
        }
        if(x<0){
            result = -result;
        }

        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(1534236469));

        Long.valueOf("9646324351");
    }
}
