package com.blackfish.java.suanfa;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/8 15:23
 * @Description:
 */
public class LongestConsecutive {

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

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }

}
