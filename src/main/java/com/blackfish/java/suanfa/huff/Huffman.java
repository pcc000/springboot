package com.blackfish.java.suanfa.huff;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Auther: pcc
 * @Date: 2022/12/8 16:15
 * @Description:
 */
public class Huffman {


    /**
     * 统计词的频率
     * @param str
     * @return
     */
    public static Map<Character,Integer> countMap(String str){
        Map<Character,Integer> countMap = new HashMap<>();
        char[] strchar = str.toCharArray();
        for(int i=0; i<strchar.length; i++){
            char c = strchar[i];
            if(countMap.keySet().contains(c)){
                countMap.put(c,countMap.get(c)+1);
            }else{
                countMap.put(c,1);
            }
        }
        return countMap;
    }

    public static class Node implements Comparable<Node> {
        public int count;
        public Node left;
        public Node right;
        public boolean isLeaf = false;
        public char c;

        public Node(int c) {
            count = c;
        }

        @Override
        public int compareTo(Node o2) {
            return this.count - o2.count;
        }
    }

    /**
     * 将词频率map转化成对应huffmanCode
  * @param countMap
     * @return
     */
    public static HashMap<Character, String> huffmanForm(HashMap<Character, Integer> countMap) {
        //如果只有一条记录直接返回对应的huffmanCode为0
        if(countMap.size() ==1){

        }
        HashMap<Character,String> huffmanCodeMap = new HashMap<>();
        PriorityQueue<Node> heap = new PriorityQueue<>();
        //1、生成对应的huffman的节点
        for(Character character : countMap.keySet()){
            Node node = new Node(countMap.get(character));
            node.isLeaf = true;
            node.c = character;
            heap.add(node);
        }
        //2、构造huffman树
        while(heap.size()!=1){
            Node left = heap.poll();
            Node right = heap.poll();
            Node node = new Node(left.count + right.count);
            node.left =left;
            node.right = right;
            heap.add(node);
        }
        Node root = heap.poll();
        //3、根据huffman树生成对应的code
        Huffman.fillForm(root,"",huffmanCodeMap);
        return huffmanCodeMap;
    }

    /**
     * 递归到叶子节点获取对应的huffmanCode的值
     * @param root
     * @param str
     * @param huffmanCodeMap
     */
    public static void fillForm(Node root,String str,HashMap<Character,String> huffmanCodeMap){
        if(root.isLeaf){
            huffmanCodeMap.put(root.c,str);
            return;
        }
        fillForm(root.left,str +"0",huffmanCodeMap);
        fillForm(root.right,str+"1",huffmanCodeMap);
    }

    public static void main(String[] args) {
        System.out.println();
        // 根据词频表生成哈夫曼编码表
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 60);
        map.put('B', 45);
        map.put('C', 13);
        map.put('D', 69);
        map.put('E', 14);
        map.put('F', 5);
        map.put('G', 3);
        HashMap<Character, String> huffmanForm = huffmanForm(map);
        for (Map.Entry<Character, String> entry : huffmanForm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }



}
