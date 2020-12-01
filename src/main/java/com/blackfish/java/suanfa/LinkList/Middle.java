package com.blackfish.java.suanfa.LinkList;

import java.util.HashMap;
import java.util.Map;

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
        Node1 cur = head;
        while(null != cur){
            cur = mergeChild(head);
            cur = cur.next;
        }
        return head;
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


    public static void printNode1(Node1 head){
        StringBuffer result = new StringBuffer();
        while(null != head){
            result.append(head.val).append(",");
            head = head.next;
        }
        System.out.println(result.toString());
    }



    public static void printNode(Node head){
        StringBuffer result = new StringBuffer();
        while(null != head){
            result.append("[").append(head.val).append(",").append(null != head.random ? head.random.val : null).append("],");
            head = head.next;
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Node1 node1 = new Node1(1);
        Node1 node2 = new Node1(2);
        Node1 node3 = new Node1(3);
        Node1 node4 = new Node1(4);
        Node1 node5 = new Node1(5);
        Node1 node6 = new Node1(6);
        node1.next = node6;
        node5.prev = node1;
        node1.child = node2;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node5;
        node5.prev = node3;
        node3.child = node4;

//        Node1 result = flatten(node1);
        Node1 result = mergeChild(node1);
        printNode1(result);

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
