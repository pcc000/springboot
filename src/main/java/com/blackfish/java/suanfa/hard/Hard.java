package com.blackfish.java.suanfa.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/27 17:49
 * @Description:
 */
public class Hard {

    /**
     * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     * 示例 1:
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     * 输入: [7,8,9,11,12]
     * 输出: 1
     * 提示：
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[result]){
                result = i;
            }
        }
        return result;
    }


    public int sumSubseqWidths(int[] nums) {
        if(nums.length==0) return 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){

            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,11,12};
        Hard h = new Hard();
        System.out.println(h.firstMissingPositive(nums));
    }
}
