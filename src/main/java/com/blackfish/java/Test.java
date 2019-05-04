package com.blackfish.java;

import java.util.Collections;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/12 11:30
 * @Description:
 */
public class Test {

    public int[] twoSum(int[] arg, int target){
        for(int i=0;i<arg.length;i++){
            for(int j=i+1;j<arg.length;j++){
                if(arg[i]+arg[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no two nums add equals target");
    }


    public static void main(String[] args) {
//        Collections.max();
        
        int[] nums = new int[]{2,3,8,7,11};
        Test test = new Test();
        System.out.println(test.twoSum(nums,9)[0]+" ,"+test.twoSum(nums,9)[1]);
    }
}
