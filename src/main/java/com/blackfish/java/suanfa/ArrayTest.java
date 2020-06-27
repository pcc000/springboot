package com.blackfish.java.suanfa;

import ch.qos.logback.classic.pattern.SyslogStartConverter;
import com.blackfish.java.util.common.JsonUtil;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/4 14:56
 * @Description:
 */
public class ArrayTest {


    /**
     * 238. 除自身以外数组的乘积
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * 示例:
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0]=1;
        for(int i=1;i<nums.length;i++){
            result[i] = result[i-1] * nums[i-1];
        }
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        result[nums.length-1] = result[nums.length-1] * right[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            right[i] = right[i+1] * nums[i+1];
            result[i] = result[i] * right[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[Integer.MAX_VALUE];
//        ArrayTest arrayTest = new ArrayTest();
//        int[] nums = new int[]{1,2,3,4};
//        System.out.println(JsonUtil.toJson(arrayTest.productExceptSelf(nums)));
    }

}
