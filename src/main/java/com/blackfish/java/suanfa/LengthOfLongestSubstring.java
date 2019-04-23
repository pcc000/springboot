package com.blackfish.java.suanfa;

import com.blackfish.java.util.client.ClientResultDTO;
import com.blackfish.java.util.client.HttpClientUtil;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/17 15:36
 * @Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring1(String s) {
        int length = s.length();
        int max=0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<=length;j++){
                if(isUnique(s,i,j)){
                    max = Math.max(max,j-i);
                }else{
                    break;
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        int i=0,j=0,max=0;
        Set<Character> set = new HashSet<>();
        while(i<length && j<length){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(j++));
            }else{
                set.add(s.charAt(i++));
                max = Math.max(max,i-j);
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int max=0;
        for(int i=0,j=0;i<length;i++){
            if(set.contains(s.charAt(i))){

            }else{
                set.add(s.charAt(i++));
                max = Math.max(max,i-j);
            }
        }
        return max;
    }

    public boolean isUnique(String s,int i,int j){
        Set<Character> set = new HashSet<Character>();
        for(int t=i;t<j;t++){
            Character ch = s.charAt(t);
            if(set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        LengthOfLongestSubstring ll = new LengthOfLongestSubstring();
        System.out.println(ll.lengthOfLongestSubstring("pwwkew"));
        }
}
