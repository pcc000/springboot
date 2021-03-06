package com.blackfish.java.suanfa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/8 15:23
 * @Description:
 */
public class LongestConsecutive {

    private String[] strs;

    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 示例:
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * https://leetcode-cn.com/problems/longest-consecutive-sequence/
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            numsSet.add(nums[i]);
        }
        int result = 0;
        for(int s : numsSet){
            int current = s;
            int currentCount = 1;
            if(numsSet.contains(s-1)){
                continue;
            }
            while(numsSet.contains(current+1)){
                current ++;
                currentCount ++;
            }
            result = result > currentCount ? result : currentCount;
        }
        return result;
    }


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        this.strs = strs;
        if(strs.length==0) return "";
        return result(strs.length-1);
    }

    private String result(int j){
        if(j==0) return strs[0];
        String before = result(j-1);
        String result ="";
        for(int k=0;k<strs[j].length();k++){
            if(k<before.length() && before.charAt(k)==strs[j].charAt(k)){
                result = result + before.charAt(k);
            }else{
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }

}
