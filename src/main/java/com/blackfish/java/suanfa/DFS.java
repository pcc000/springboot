package com.blackfish.java.suanfa;

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
    }

}

class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
     public TreeNode(int val) {
        this.val = val;
    }

}
