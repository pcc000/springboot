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
    private String value;

    /**
     * 入度
     */
    private Integer in;

    /**
     * 出度
     */
    private Integer out;

    /**
     * 当前节点指向的节点
     */
    private List<Node> nexts;

    /**
     * 从当前节点出发的边
     */
    private List<Edge> edges;

    public Node(String value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
