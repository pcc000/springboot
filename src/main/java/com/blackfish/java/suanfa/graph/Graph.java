package com.blackfish.java.suanfa.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: pcc
 * @Date: 2022/12/14 16:25
 * @Description:
 */
public class Graph {

    public Map<String,Node> nodes;

    public Set<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
