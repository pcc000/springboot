package com.blackfish.java.suanfa.LinkList;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/7 20:49
 * @Description:
 */
public class Simple {

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(null != cur){
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Middle.printListNode(n1);
        Middle.printListNode(reverseList(n1));
    }
}
