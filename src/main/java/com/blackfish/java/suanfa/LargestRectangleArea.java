package com.blackfish.java.suanfa;

import java.util.ArrayList;
import java.util.List;

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


    /**
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     *
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max =0;
        for(int i=0;i<candies.length;i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }
        List<Boolean> resultList = new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i] + extraCandies >= max){
                resultList.add(true);
            }else{
                resultList.add(false);
            }
        }
        return resultList;
    }


    /**
     *
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(null == root){
            return true;
        }
        return recursiveTree(root.left,root.right);
    }

    private boolean recursiveTree(TreeNode left,TreeNode right){
        if(null != right && null != left){
            if(right.val != left.val){
                return false;
            }else{
                return recursiveTree(left.left,right.right) && recursiveTree(left.right,right.left);
            }
        }else if((null == right && null != left) || (null != right && null == left)){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
//        int[] heights = new int[]{2,1,2};
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
//        int result = largestRectangleArea.largestRectangleArea(heights);
//
//        System.out.println(result);

        TreeNode root = new TreeNode(234);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        root.left=rootLeft;
        root.right=rootRight;
        System.out.println(largestRectangleArea.isSymmetric(root));

    }

}
