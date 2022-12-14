package com.blackfish.java.suanfa.graph;

/**
 * @Auther: pcc
 * @Date: 2022/12/14 16:24
 * @Description:
 */
public class Edge {

    public Integer weight;

    public Node from;

    public Node to;

    public Edge(Integer weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
