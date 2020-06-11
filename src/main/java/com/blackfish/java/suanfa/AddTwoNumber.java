package com.blackfish.java.suanfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/17 13:16
 * @Description:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class AddTwoNumber {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i < nums.length; i++){
            if(map.get(target-nums[i])!=null){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,7,3};
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        System.out.println(addTwoNumber.twoSum(nums,9)[0]+","+addTwoNumber.twoSum(nums,9)[1]);
    }
}
