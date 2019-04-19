package com.blackfish.java.suanfa;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/17 11:09
 * @Description:
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1,q=l2,curr = result;
        int carry =0;
        while(p != null  || q != null){
            int x = p!=null ? p.val : 0;
            int y = q!=null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum /10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        if(carry>0){
            curr.next  = new ListNode(carry);
        }
        return result.next;
    }

    public String printListNode(ListNode listNode){
        StringBuffer str = new StringBuffer();
        ListNode temp = listNode;
        while(temp != null){
            str.append(temp.val+"->");
            temp = temp.next;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(9);

        Solution solution = new Solution();
        System.out.println("param:");
        System.out.println("l1:"+solution.printListNode(l1));
        System.out.println("l2:"+solution.printListNode(l2));
        ListNode result = solution.addTwoNumbers(l1,l2);
        System.out.println("result:"+solution.printListNode(result));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
