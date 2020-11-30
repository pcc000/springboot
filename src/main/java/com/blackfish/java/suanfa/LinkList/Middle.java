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


    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
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

    public static void print(Node head){
        StringBuffer result = new StringBuffer();
        while(null != head){
            result.append("[").append(head.val).append(",").append(null != head.random ? head.random.val : null).append("],");
            head = head.next;
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;



        print(node1);

        System.out.println("=================");
        print(copyRandomList(node1));
    }
}
