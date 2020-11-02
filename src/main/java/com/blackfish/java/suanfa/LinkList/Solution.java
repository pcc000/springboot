package com.blackfish.java.suanfa.LinkList;

/**
 * @Auther: shuyiwei
 * @Date: 2020/10/31 16:11
 * @Description:
 */
public class Solution {

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     *
     * 返回删除后的链表的头节点。
     *
     * 注意：此题对比原题有改动
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     *
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *  
     *
     * 说明：
     *
     * 题目保证链表中节点的值互不相同
     * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode headPre = new ListNode(val);
        headPre.next = head;
        ListNode helpPre = headPre;
        ListNode help = headPre.next;
        while(null != help){
            if(help.val==val){
                help = help.next;
                helpPre.next = help;
            }else{
                helpPre = helpPre.next;
                help = help.next;
            }
        }
        return headPre.next;
    }

    public static ListNode deleteNode2(ListNode head, int val) {
        while(null != head){
            if(head.val==val){
                head = head.next;
                return head;
            }else{
                break;
            }
        }
        ListNode pre = head;
        ListNode cur = head;
        while(null != cur){
            if(val == cur.val){
                pre.next = cur.next;
                return head;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        ListNode cur = headPre.next;
        ListNode curPre = headPre;
        while(null != cur){
            ListNode secondCur = cur.next;
            ListNode secondCurPre = cur;
            Boolean isSame = false;
            while(null != secondCur){
                if(cur.val==secondCur.val){
                    secondCur = secondCur.next;
                    secondCurPre.next = secondCur;
                    isSame = true;
                }else{
                    secondCurPre = secondCurPre.next;
                    secondCur = secondCur.next;
                }
            }
            if(isSame){
                cur = cur.next;
                curPre.next = cur;
            }else{
                cur = cur.next;
                curPre = curPre.next;
            }
        }
        return headPre.next;
    }


    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     *
     *  
     *
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     *
     *
     *
     *  
     *
     * 示例 1：
     *
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2：
     *
     * 输入：head = [4,5,1,9], node = 1
     * 输出：[4,5,9]
     * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *  
     *
     * 提示：
     *
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     * 通过次数137,034提交次数164,601
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param node
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * 注意：本题相对原题稍作改动
     * 示例：
     *
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     * 说明：
     *
     * 给定的 k 保证是有效的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param k
     * @return
     */
    public static int kthToLast(ListNode head, int k) {
        if(null == head){
            return -1;
        }
        if(null == head.next){
            return head.val;
        }
        ListNode before = head;
        ListNode cur = head.next;
        while(null != cur){
            ListNode next = cur.next;
            cur.next = before;
            before = cur;
            cur = next;
            if(cur == next){
                head = before;
            }
        }
        int i=1;
        cur = head;
        while(null != head){
            if(i++ == k){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        return null;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 示例1：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 限制：
     *
     * 0 <= 链表长度 <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null ==l1) return l2;
        if(null ==l2) return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head,l1Cur = l1,l2Cur =l2;
        while(null != l1Cur && null != l2Cur){
            if(l2Cur.val < l1Cur.val ){
                cur.next = l2Cur;
                cur = l2Cur;
                l2Cur = l2Cur.next;
            }else{
                cur.next = l1Cur;
                cur = l1Cur;
                l1Cur = l1Cur.next;
            }
        }
        while(null != l1Cur){
            cur.next = l1Cur;
            cur = l1Cur;
            l1Cur = l1Cur.next;
        }
        while(null != l2Cur){
            cur.next = l2Cur;
            cur = l2Cur;
            l2Cur = l2Cur.next;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode s1 = new ListNode(2);
        root.next=s1;
        ListNode s2 = new ListNode(4);
        s1.next=s2;
//        ListNode s3 = new ListNode(7);
//        s2.next=s3;

        ListNode root1 = new ListNode(1);
        ListNode s11 = new ListNode(3);
        root1.next=s11;
        ListNode s21 = new ListNode(4);
        s11.next=s21;
        ListNode s31 = new ListNode(9);
        s21.next=s31;

        System.out.println("==========param:");
        printListNode(root);
        printListNode(root1);
        printListNode(mergeTwoLists(root1,root));
        System.out.println("==========result:");
//        printListNode(deleteDuplicates(root));
    }

    public static void  printListNode(ListNode root){
        StringBuffer result = new StringBuffer();
        ListNode help = root;
        while(help != null){
            result.append(help.val).append("->");
            help = help.next;
        }
        System.out.println(result.toString());
    }

}
