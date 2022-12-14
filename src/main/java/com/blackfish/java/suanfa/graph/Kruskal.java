package com.blackfish.java.suanfa.graph;

import java.util.*;

/**
 * @Auther: pcc
 * @Date: 2022/12/14 19:21
 * @Description:
 */
public class Kruskal {

    public static class UnionFind{

        private Map<Node,Node> parentMap;

        private Map<Node,Integer> sizeMap;

        public UnionFind() {
            this.parentMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
        }

        /**
         * 初始化集合
         * @param nodeList
         */
        public void initUnion(Collection<Node> nodeList){
            parentMap.clear();
            sizeMap.clear();
            for(Node node : nodeList){
                parentMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        /**
         * 判断两个节点是否在同一个集合中
         * @param node1
         * @param node2
         * @return
         */
        public boolean isSameUnion(Node node1,Node node2){
            return findParent(node1) == findParent(node2);
        }

        /**
         * 查找唯一父节点
         * @param node
         * @return
         */
        public Node findParent(Node node){
            while(node != parentMap.get(node)){
                node = parentMap.get(node);
            }
            //待优化压缩路径
            return node;
        }

        /**
         * 合并两个集合
         * @param node1
         * @param node2
         */
        public void union(Node node1, Node node2){
            if (node1 == null || node2 == null) {
                return;
            }
            Node node1Parent = findParent(node1);
            Node node2Parent = findParent(node2);
            if(node1Parent != node2Parent){
                if(sizeMap.get(node1Parent) <= sizeMap.get(node2Parent)){
                    parentMap.put(node1,node2Parent);
                    sizeMap.put(node2Parent,sizeMap.get(node1Parent) + sizeMap.get(node2Parent));
                    sizeMap.remove(node1Parent);
                }else{
                    parentMap.put(node2,node1Parent);
                    sizeMap.put(node1Parent,sizeMap.get(node1Parent) + sizeMap.get(node2Parent));
                    sizeMap.remove(node2Parent);
                }
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }


    public static Set<Edge> kruskalMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.initUnion(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for(Edge edge : graph.edges){
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            //判断2个点间是否已经联通过
            if(!unionFind.isSameUnion(edge.from,edge.to)){
                unionFind.union(edge.from,edge.to);
                result.add(edge);
            }
        }
        return result;
    }
}
