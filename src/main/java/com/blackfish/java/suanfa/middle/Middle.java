package com.blackfish.java.suanfa.middle;

import com.blackfish.java.util.common.JsonUtil;

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


    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     *
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {




        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * 示例 1:
     * 输入:
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出: 3
     * 解释:
     * 长度最长的公共子数组是 [3, 2, 1]。
     * 说明:
     *
     * 1 <= len(A), len(B) <= 1000
     * 0 <= A[i], B[i] < 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        if(A.length==0 || B.length==0) return 0;
        int result =0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int k=0;
                while(i+k<A.length && j+k<B.length && A[i+k]==B[j+k]){
                    k++;
                    result = Math.max(k,result);
                }

            }
        }
        return result;
    }



    public static void main(String[] args) {
        Middle middle = new Middle();
//        int[] nums = new int[]{2,3,1,2,4,3};
//        System.out.println(middle.minSubArrayLen(4,nums));
//        int[] nums1 = new int[]{1,3,5,7,9,2,6};
//        Arrays.sort(nums1);
//        System.out.println(JsonUtil.toJson(nums1));
//        System.out.println(middle.findKthLargest(nums1,3));
//        System.out.println(Arrays.binarySearch(nums1,6));
        int[] A = new int[]{1,3,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        System.out.println(middle.findLength(A,B));

    }
}
