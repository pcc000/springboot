package com.blackfish.java.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2019/9/21 16:43
 * @Description:
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 */
public class BalloonNumTest {

    public static void main(String[] args) {
        BalloonNumTest test = new BalloonNumTest();
        System.out.println(test.maxNumberOfBalloons("loonbalxballpoon"));
    }


    public int maxNumberOfBalloons(String text) {
        if(text==null || text.length()<7){
            return 0;
        }
        int a=0,b=0,l=0,o=0,n=0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)=='a'){
                a++;
            }else if(text.charAt(i)=='b'){
                b++;
            }else if(text.charAt(i)=='l'){
                l++;
            }else if(text.charAt(i)=='o'){
                o++;
            }else if(text.charAt(i)=='n'){
                n++;
            }
        }
        int i = Math.min(l,o);
        int k = Math.min(n,Math.min(a,b));
        if(i<2){
            return 0;
        }
        if(2*k<i){
            return k;
        }else{
            return i/2;
        }


    }
}
