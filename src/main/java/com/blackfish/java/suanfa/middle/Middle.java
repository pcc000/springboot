package com.blackfish.java.suanfa.middle;

import java.util.Arrays;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/28 18:55
 * @Description:
 */
public class Middle {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
     * 示例: 
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     * 进阶:
     * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==1){
            return nums[0]>=s ? 1 : 0;
        }
        int result =0;
        for(int i=0;i<nums.length;i++){
            int k = i,sum =0;
            while(k<nums.length){
                sum = sum + nums[k];
                if(sum>=s){
                    result = result ==0 ? (k-i+1) : Math.min(result,k-i+1);
                    break;
                }
                k++;
            }

        }
        return result;
    }


    public static void main(String[] args) {
        Middle middle = new Middle();
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(middle.minSubArrayLen(4,nums));
        int[] nums1 = new int[]{1,3,5,7,9};
        System.out.println(Arrays.binarySearch(nums1,6));

    }
}
