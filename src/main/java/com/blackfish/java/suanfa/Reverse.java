package com.blackfish.java.suanfa;

public class Reverse {

    public int reverse(int x) {
        if(x==0){
            return 0;
        }

        long tem = x;
        String str = String.valueOf(Math.abs(tem));
        System.out.println(str);
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
        System.out.println(stringBuffer.toString());
        long result = Long.valueOf(stringBuffer.toString());

        if(result>0x7fffffff || result<0x80000000){
            return 0;
        }
        if(x<0){
            result = -result;
        }

        return (int)result;
    }

    public int reverse2(int x){
        int result=0,ten =0;
        while(x!=0){
            ten = x%10;
            if(result > 0x7fffffff/10 || (result == 0x7fffffff/10 && ten > 0x7fffffff%10) || result<0x80000000/10 ||(result == 0x80000000/10 && ten < 0x80000000%10)) return 0;
            result = result*10+ten;
            x = x/10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse2(-12300));

        Long.valueOf("9646324351");

        System.out.println(Integer.MIN_VALUE);

        int s = -2147483648;
        System.out.println(s);
        System.out.println(s-1);

//        System.out.println(0x80000000);
    }
}
