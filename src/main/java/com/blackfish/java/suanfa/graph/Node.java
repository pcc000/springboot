package com.blackfish.java.suanfa.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: pcc
 * @Date: 2022/12/14 16:21
 * @Description:
 */
public class Node {

    /**
     * 节点值
     */
    public String value;

    /**
     * 入度
     */
    public Integer in;

    /**
     * 出度
     */
    public Integer out;

    /**
     * 当前节点指向的节点
     */
    public List<Node> nexts;

    /**
     * 从当前节点出发的边
     */
    public List<Edge> edges;

    public Node(String value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
