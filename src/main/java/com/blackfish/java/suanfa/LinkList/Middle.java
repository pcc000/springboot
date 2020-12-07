package com.blackfish.java.suanfa.LinkList;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: shuyiwei
 * @Date: 2020/11/30 19:37
 * @Description:
 */
public class Middle {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static class Node1 {
        public int val;
        public Node1 prev;
        public Node1 next;
        public Node1 child;

        public Node1(int val) {
            this.val = val;
        }
    };


    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     *
     *
     * 使用map来保存  不用map实现尼？
     */
    public static Node copyRandomList(Node head) {
        if(null == head) return null;
        Map<Node,Node> map = new HashMap<>();
        Node headTemp = head;
        while(null != head){
            map.put(head,new Node(head.val));
            head = head.next;
        }
        for(Node node : map.keySet()){
            Node temp = map.get(node);
            temp.next = map.get(node.next);
            temp.random = map.get(node.random);
        }
        return map.get(headTemp);
    }


    /**
     *多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
     *
     * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
     * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
     * 解释：
     *
     * 输入的多级列表如下图所示：
     *
     *
     *
     * 扁平化后的链表如下图：
     *
     *
     * 示例 2：
     *
     * 输入：head = [1,2,null,3]
     * 输出：[1,3,2]
     * 解释：
     *
     * 输入的多级列表如下图所示：
     *
     *   1---2---NULL
     *   |
     *   3---NULL
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     *  
     *
     * 如何表示测试用例中的多级链表？
     *
     * 以 示例 1 为例：
     *
     *  1---2---3---4---5---6--NULL
     *          |
     *          7---8---9---10--NULL
     *              |
     *              11--12--NULL
     * 序列化其中的每一级之后：
     *
     * [1,2,3,4,5,6,null]
     * [7,8,9,10,null]
     * [11,12,null]
     * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
     *
     * [1,2,3,4,5,6,null]
     * [null,null,7,8,9,10,null]
     * [null,11,12,null]
     * 合并所有序列化结果，并去除末尾的 null 。
     *
     * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
     *  
     *
     * 提示：
     *
     * 节点数目不超过 1000
     * 1 <= Node.val <= 10^5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public static Node1 flatten(Node1 head) {
        if(null == head) return null;
        Node1 preHead = new Node1(0);
        preHead.next = head;
        getTail(preHead,head);
        preHead.next.prev = null;
        return preHead.next;
    }

    public static Node1 getTail(Node1 pre,Node1 cur){
        if(null == cur) return pre;
        cur.prev = pre;
        pre.next = cur;
        Node1 nextTemp = cur.next;
        Node1 tail = getTail(cur,cur.child);
        cur.child = null;
        return getTail(tail,nextTemp);
    }

    public static Node1 mergeChild(Node1 node){
        Node1 childCur = node.child;
        if(null != childCur){
            Node1 childNode = mergeChild(childCur);
            Node1 curNode = node;
            Node1 nextNode = node.next;
            curNode.next = childNode;
            childNode.prev = curNode;
            while(null != curNode.next){
                curNode = curNode.next;
                curNode = mergeChild(curNode);
            }
            curNode.next = nextNode;
            if(null != nextNode) node.next.prev = curNode;
        }
        node.child=null;
        return node;
    }


    public static Node1 getChildNode(Node1 node){
        Node1 head = null;
        if(null != node.child){
            head = node.child;
        }
        return head;
    }


    public static void printNode1(Node1 head){
        StringBuffer result = new StringBuffer();
        while(null != head){
            result.append(head.val).append(",");
            head = head.next;
        }
        System.out.println(result.toString());
    }

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例 2:
     *
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(null == head) return head;
        if(null == head.next) return head;
        ListNode cur = head;
        int count =1;
        while(null != cur.next){
            count++;
            cur = cur.next;
        }
        cur.next = head;
        int move = count-k%count;

        ListNode tail = head;
        while(move!=1){
            move--;
            tail = tail.next;

        }
        ListNode newHead = tail.next;
        tail.next=null;
        return newHead;
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headTemp = new ListNode(0);
        ListNode cur = headTemp;
        while(null != l1 && null != l2){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = null!=l1 ? l1 : l2;
        return headTemp.next;
    }

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * 进阶：
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * 示例：
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1) return l2;
        if(null == l2) return l1;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while(null != l1){
            s1.add(l1);
            l1 = l1.next;
        }
        while(null != l2){
            s2.add(l2);
            l2 = l2.next;
        }
        Stack<ListNode> resultStack = new Stack<>();
        int in =0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            int v1 = s1.pop().val,v2 = s2.pop().val;
            resultStack.add(new ListNode((v1+v2+in)<=9 ? v1+v2+in : v1+v2+in-10));
            in = (v1+v2+in)<=9 ? 0 : 1;
        }
        while (!s1.isEmpty()){
            ListNode temp = s1.pop();
            resultStack.add(new ListNode(temp.val+in<=9 ? temp.val+in : temp.val+in-10));
            in= temp.val+in<=9 ? 0: 1;
        }
        while (!s2.isEmpty()){
            ListNode temp = s2.pop();
            resultStack.add(new ListNode(temp.val+in<=9 ? temp.val+in : temp.val+in-10));
            in= temp.val+in<=9 ? 0: 1;
        }
        if(in ==1){
            resultStack.add(new ListNode(1));
        }
        ListNode resultHeadTemp  = new ListNode(-1);
        ListNode cur = resultHeadTemp;
        while (!resultStack.isEmpty()){
            cur.next = resultStack.pop();
            cur = cur.next;
        }
        return resultHeadTemp.next;
    }


    public  static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(null == l1) return l2;
        if(null == l2) return l1;
        long vaule1 =0;
        while(null != l1){
            vaule1 = vaule1*10 +  l1.val;
            l1 = l1.next;
        }
        long vaule2 =0;
        while(null != l2){
            vaule2 = vaule2*10 +  l2.val;
            l2 = l2.next;
        }
        Long resultValue = vaule1 + vaule2;
        if(resultValue==0){
            return new ListNode(0);
        }
        Stack<ListNode> stack = new Stack<>();
        while(resultValue >0){
            Long temp = resultValue%10;
            stack.push(new ListNode(temp.intValue()));
            resultValue = resultValue/10;
        }

        ListNode head = stack.pop();
        ListNode cur = head;
        while(!stack.isEmpty()){
            cur.next=stack.pop();
            cur = cur.next;
        }
        return head;
    }


    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例 1:
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * 示例 2:
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reorder-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     */
    public static void reorderList(ListNode head) {

        ListNode mid = getMide(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);

        while(null != l1 && null !=l2){
            ListNode l1next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            l2.next = l1next;
            l1 = l1next;
            l2 = l2Next;
        }

    }

    public static void reorderList1(ListNode head) {
        int count =0;
        ListNode cur = head;
        while(null != cur){
            count ++;
            cur = cur.next;
        }

        Stack<ListNode> reverse = new Stack<>();
        count = count/2;
        int i =count;
        cur = head;
        while(i!=0){
            i --;
            cur = cur.next;
        }
        while(null != cur){
            reverse.add(cur);
            cur = cur.next;
        }
        cur = head;
        while(!reverse.isEmpty() && count>0){
            count --;
            ListNode temp = reverse.pop();
            temp.next =  cur.next;
            cur.next = temp;
            if(count==0){
                temp.next= reverse.isEmpty() ? null : reverse.pop();
                if(null !=temp.next)temp.next.next=null;

            }
            cur = cur.next.next;
        }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 获取链表中间位置
     * @param head
     * @return
     */
    public static ListNode getMide(ListNode head){
        ListNode fast = head,slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



    public static void printNode(Node head){
        StringBuffer result = new StringBuffer();
        while(null != head){
            result.append("[").append(head.val).append(",").append(null != head.random ? head.random.val : null).append("],");
            head = head.next;
        }
        System.out.println(result.toString());
    }

    public static void printListNode(ListNode head){
        StringBuffer result = new StringBuffer();
        while(null != head){
            result.append(head.val).append(",");
            head = head.next;
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        printListNode(node1);
        reorderList(node1);


        printListNode(node1);




        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
//        node4.next=node5;
//        node5.next=node6;
//        node6.next=node7;
//        node7.next=node8;
//        node8.next=node9;
//        node9.next=node10;
//        node10.next=node11;
//        node11.next=node12;
//        node12.next=node13;

//        printListNode(node1);
//        printListNode(node4);
//        printListNode(addTwoNumbers(node1,node4));


//        Node1 node1 = new Node1(1);
//        Node1 node2 = new Node1(2);
//        Node1 node3 = new Node1(3);
//        Node1 node4 = new Node1(4);
//        Node1 node5 = new Node1(5);
//        Node1 node6 = new Node1(6);
//        node1.next = node6;
//        node5.prev = node1;
//        node1.child = node2;
//        node2.next = node3;
//        node3.prev = node2;
//        node3.next = node5;
//        node5.prev = node3;
//        node3.child = node4;
//
////        Node1 result = flatten(node1);
//        Node1 result = mergeChild(node1);
//        printNode1(result);

//        Node node1 = new Node(7);
//        Node node2 = new Node(13);
//        Node node3 = new Node(11);
//        Node node4 = new Node(10);
//        Node node5 = new Node(1);
//        node1.next = node2;
//        node1.random = null;
//        node2.next = node3;
//        node2.random = node1;
//        node3.next = node4;
//        node3.random = node5;
//        node4.next = node5;
//        node4.random = node3;
//        node5.random = node1;
//        printNode(node1);
//        System.out.println("=================");
//        printNode(copyRandomList(node1));
    }
}
