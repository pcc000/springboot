package com.blackfish.java.suanfa.simple;

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

    public static void main(String[] args) {
        Simple simple = new Simple();
        int[] nums = simple.divingBoard(2,2,3);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }

//        TreeNode root = new TreeNode(5);
//
//        TreeNode left = new TreeNode(4);
//        root.left = left;
//
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