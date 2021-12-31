package com.blackfish.java.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2019/12/16 17:31
 * @Description:
 */
public class DFS {

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * https://leetcode-cn.com/problems/validate-binary-search-tree/
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTDFS(root,null,null);
    }

    private boolean isValidBSTDFS(TreeNode root,Integer max,Integer min){
        if(null == root) return true;
        if((null != max && root.val>=max) || (null != min && root.val <= min)) return false;
        return isValidBSTDFS(root.left,root.val,min) && isValidBSTDFS(root.right,max,root.val);
    }


    /**
     *
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
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
        if(null == left && null == right) return true;
        if(null == left || null == right || left.val!=right.val) return false;
        return recursiveTree(left.left,right.right) && recursiveTree(left.right,right.left);
        //原思路
//        if(null != right && null != left){
//            if(right.val != left.val){
//                return false;
//            }else{
//                return recursiveTree(left.left,right.right) && recursiveTree(left.right,right.left);
//            }
//        }else if((null == right && null != left) || (null != right && null == left)){
//            return false;
//        }
//        return true;
    }


    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(null == root){
            return true;
        }
        if(!isBalanced(root.right) || !isBalanced(root.left)){
            return false;
        }
        return Math.abs(treeDepth(root.left)-treeDepth(root.right)) > 1 ? false : true;
    }

    private int treeDepth(TreeNode treeNode){
        if(null == treeNode) return 0;
        int rightDepth = treeDepth(treeNode.right);
        int leftDepth = treeDepth(treeNode.left);
        return 1 + (rightDepth > leftDepth ? rightDepth : leftDepth);
    }


    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        if(nums.length==1) return new TreeNode(nums[0]);
        int center = nums.length/2;
        TreeNode root = new TreeNode(nums[center]);
        int[] left = new int[center];
        int[] right = new int[nums.length-center-1];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(i<center){
                left[i] = nums[i];
            }
            if(i>center){
                right[j++] = nums[i];
            }
        }
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }


    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList<>();
        return generateTree(1,n);
    }

    private List<TreeNode> generateTree(int left,int right){
        List<TreeNode> resultList = new ArrayList<>();
        if(left > right){
            resultList.add(null);
            return resultList;
        }
        for(int i = left ; i<= right;i++){
            List<TreeNode> leftTreeNodeList = generateTree(left,i-1);
            List<TreeNode> rightTreeNodeList = generateTree(i+1,right);
            for(TreeNode l : leftTreeNodeList){
                for(TreeNode r : rightTreeNodeList){
                    TreeNode root = new TreeNode(i,l,r);
                    resultList.add(root);
                }
            }
        }
        return resultList;
    }

    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     * 示例:
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0]=1;
        G[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                G[i] = G[i] + G[j-1]*G[i-j];
            }
        }
        return G[n];
    }



    public static void main(String[] args) {

        DFS dfs = new DFS();
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(1);
        TreeNode rootRight = new TreeNode(5);
        TreeNode rootRightL = new TreeNode(2);
        TreeNode rootRightR = new TreeNode(6);
        root.left=rootLeft;
        root.right=rootRight;
        rootRight.left = rootRightL;
        rootRight.right = rootRightR;
        System.out.println(dfs.isSymmetric(root));

        System.out.println(dfs.isValidBST(root));


        int[] nums = new int[]{-10,-3,0,5,9};
        System.out.println(dfs.sortedArrayToBST(nums));

        List<TreeNode> treeNodeList = dfs.generateTrees(5);
        System.out.println("treeNodeList size:"+treeNodeList.size());
        System.out.println(dfs.numTrees(5));
    }

}

class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int val) {
        this.val = val;
    }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
}
