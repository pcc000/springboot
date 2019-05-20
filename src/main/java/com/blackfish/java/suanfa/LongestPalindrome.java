package com.blackfish.java.suanfa;

import org.springframework.util.StringUtils;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/14 19:29
 * @Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {


    public static String longestPalindrome(String s){
        if(StringUtils.isEmpty(s)){
            return "";
        }
        int max=1;
        int start=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                int t1=i,t2=j;
                while(t1<t2 && s.charAt(t1)==s.charAt(t2)){
                    t1++;
                    t2--;
                }
                if(t1>=t2 && j-i+1>max){
                    start = i;
                    max = j-i+1;
                }
            }

        }
        return s.substring(start,start+max);
    }

    public static String longestPalindrome2(String s){



        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));
    }


}
