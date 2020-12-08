package com.blackfish.java.suanfa.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/8 17:27
 * @Description:
 */
public class Tree {
    public int value;
    public Tree left;
    public Tree right;
    public Tree(int value) {
        this.value = value;
    }

    /**
     * 先序递归
     * @param root
     */
    public static void preRecursiveTraversalBinaryTree(Tree root){
        if(null == root) return ;
        System.out.println(root.value);
        preRecursiveTraversalBinaryTree(root.left);
        preRecursiveTraversalBinaryTree(root.right);
    }

    /**
     * 先序非递归
     * @param root
     */
    public static void preNoRecursiveTraversalBinaryTree(Tree root){
        if(null == root) return;
        Stack<Tree> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Tree tree = stack.pop();
            System.out.println(tree.value);
            if(null != tree.right) stack.add(tree.right);
            if(null != tree.left) stack.add(tree.left);
        }
    }

    /**
     * 中序递归
     * @param root
     */
    public static void inRecursiveTraversalBinaryTree(Tree root){
        if(null == root) return;
        inRecursiveTraversalBinaryTree(root.left);
        System.out.println(root.value);
        inRecursiveTraversalBinaryTree(root.right);
    }

    /**
     * 中序非递归
     * @param root
     */
    public static void inNoRecursiveTraversalBinaryTree(Tree root){
        if(null == root) return;
        Stack<Tree> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Tree tree = stack.peek();
            if(tree.right!=null){
                stack.pop();
                stack.add(tree.right);
                stack.add(tree);
            }
            if(tree.left!=null){

            }
        }
    }

    /**
     * 后序递归
     * @param root
     */
    public static void afterRecursiveTraversalBinaryTree(Tree root){
        if(null == root) return;
        afterRecursiveTraversalBinaryTree(root.left);
        afterRecursiveTraversalBinaryTree(root.right);
        System.out.println(root.value);
    }

    /**
     * 按层级遍历
     * @param root
     */
    public static void levelTraversalBinaryTree(Tree root){
        if(null == root) return;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Tree tree = queue.poll();
            System.out.println(tree.value);
            if(null != tree.left){
                queue.add(tree.left);
            }
            if(null != tree.right){
                queue.add(tree.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);
        preRecursiveTraversalBinaryTree(root);
        System.out.println("=================");
        preNoRecursiveTraversalBinaryTree(root);
        System.out.println("================================");
        inRecursiveTraversalBinaryTree(root);
        System.out.println("=================");
        afterRecursiveTraversalBinaryTree(root);
        System.out.println("=================");
        levelTraversalBinaryTree(root);
    }
}
