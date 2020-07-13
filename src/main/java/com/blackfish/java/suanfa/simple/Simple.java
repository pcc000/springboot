package com.blackfish.java.suanfa.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2020/7/8 16:19
 * @Description:
 */
public class Simple {
    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为
     * shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * 返回的长度需要从小到大排列。
     * 示例：
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： {3,4,5,6}
     *
     * 1 1
     * 1 2
     * 2 2
     *
     * 1 1 1
     * 1 1 2
     * 1 2 2
     * 2 2 2
     *
     * 1 1 1 1
     * 1 1 1 2
     * 1 1 2 2
     * 1 2 2 2
     * 2 2 2 2
     *
     * 1 1 1 1 1
     * 1 1 1 1 2
     * 1 1 1 2 2
     * 1 1 2 2 2
     * 1 2 2 2 2
     * 2 2 2 2 2
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diving-board-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{};
        }
        if(shorter==longer){
            return new int[]{shorter*k};
        }
        int[] result = new int[k+1];
        for(int i=0;i<=k;i++){
            result[i] = i * longer + (k-i)*shorter;
        }
        return result;
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(null == root){
            return false;
        }
        return depDFS(root,sum,0);
    }

    private boolean depDFS(TreeNode root, int sum,int countSum){
        if(null == root.left && root.right==null){
            if(sum == root.val+countSum){
                return true;
            }else{
                return false;
            }
        }
        countSum = countSum + root.val;
        if(null != root.left && depDFS(root.left,sum,countSum)) return true;
        if(null != root.right && depDFS(root.right,sum,countSum)) return true;
        return false;
    }


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *  
     *
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(null == countMap.get(nums1[i])){
                countMap.put(nums1[i],1);
            }else{
                countMap.put(nums1[i],countMap.get(nums1[i])+1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(null != countMap.get(nums2[i]) && countMap.get(nums2[i])>0){
                resultList.add(nums2[i]);
                countMap.put(nums2[i],countMap.get(nums2[i])-1);
            }
        }
        int[] result = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Simple simple = new Simple();

        int[] num1 = new int[]{4,9,5};
        int[] num2 = new int[]{9,4,9,8,4};

        int[] reslt = simple.intersect(num1,num2);
        for(int i=0;i<reslt.length;i++){
            System.out.print(reslt[i]+" ");
        }


//        int[] nums = simple.divingBoard(2,2,3);
//        for(int i=0;i<nums.length;i++){
//            System.out.print(nums[i]+" ");
//        }
//        TreeNode root = new TreeNode(5);
//        TreeNode left = new TreeNode(4);
//        root.left = left;
//        TreeNode left1 = new TreeNode(11);
//        TreeNode left1left = new TreeNode(7);
//        TreeNode left1right = new TreeNode(2);
//        left1.left = left1left;
//        left1.right = left1right;
//        left.left = left1;
//
//
//        TreeNode right = new TreeNode(8);
//        root.right = right;
//
//        TreeNode rightleft = new TreeNode(13);
//        TreeNode right2 = new TreeNode(4);
//        right.left=rightleft;
//        right.right= right2;
//
//        TreeNode right3 = new TreeNode(1);
//
//        right2.right = right3;
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left=left;



        System.out.println(simple.hasPathSum(root,1));


    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}