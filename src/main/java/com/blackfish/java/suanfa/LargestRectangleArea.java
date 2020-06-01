package com.blackfish.java.suanfa;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/1 15:46
 * @Description:
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 力扣 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        if(heights.length == 1){
            return heights[0];
        }
        int result =0;
        for(int i=0;i<heights.length;i++){
            int temp =heights[i];
            for(int j=i+1;j<heights.length;j++){
                if(heights[j]<heights[i]){
                    break;
                }else{
                    temp = temp + heights[i];
                }
            }
            for(int k = i-1;k>=0;k--){
                if(heights[k]<heights[i]){
                    break;
                }else{
                    temp = temp + heights[i];
                }
            }
            result = temp > result ? temp : result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,2};
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int result = largestRectangleArea.largestRectangleArea(heights);

        System.out.println(result);
    }

}
