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
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isValidBSTDFS(root);
    }

    private boolean isValidBSTDFS(TreeNode root){
//        if(null != root.getLeft() && root.getVal()>root.getLeft().getVal()){
//            isValidBSTDFS(root.getLeft());
//        }else {
//            return false;
//        }
//        if(null != root.getRight() && root.getVal()<root.getRight().getVal()){
//            isValidBSTDFS(root.getRight());
//        }else{
//            return false;
//        }
        return true;
    }

    public static void main(String[] args) {

    }

}

class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }

//    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public TreeNode getLeft() {
//        return left;
//    }
//
//    public void setLeft(TreeNode left) {
//        this.left = left;
//    }
//
//    public TreeNode getRight() {
//        return right;
//    }
//
//    public void setRight(TreeNode right) {
//        this.right = right;
//    }
}
