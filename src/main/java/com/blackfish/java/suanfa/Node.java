package com.blackfish.java.suanfa;

import com.blackfish.java.util.common.JsonUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: pcc
 * @Date: 2021/12/30 16:35
 * @Description:
 */
public class Node {

    public String name;

    public Integer level;

    public List<Node> children;

    public Node(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"浙江省/宁波市/海曙区/学校1", "浙江省/宁波市/海曙区/学校2", "浙江省/宁波市/江北区/学校1", "浙江省/宁波市/江北区/学校2", "浙江省/宁波市/鄞州区/学校1", "浙江省/杭州市/上城区/学校1", "浙江省/杭州市/上城区/学校2", "浙江省/杭州市/下城区/学校1", "浙江省/杭州市/西湖区/学校1", "浙江省/杭州市/下沙区/学校1", "江苏省/南京市/鼓楼区/学校1", "江苏省/南京市/浦口区/学校1", "江苏省/无锡市/惠山区/学校1"};
        List<Node> resultList = new ArrayList<>();
        for(String str : strs){
            String[] indexString = str.split("/");
            trace(indexString,resultList);
        }
        System.out.println(JsonUtil.toJson(resultList));
    }

    public static void trace(String[] nameDetail,List<Node> nodeList){
        Node parent = null;
        List<Node> nodeListTemp = nodeList;
        for(int i=0;i<nameDetail.length; i++){
            parent = isInNode(parent,(i+1),nameDetail[i],nodeListTemp);
            if(!CollectionUtils.isEmpty(parent.getChildren())){
                nodeListTemp = parent.getChildren();
            } else{
                nodeListTemp = new ArrayList<>();
            }
        }
    }

    /**
     *
     * @param parent
     * @param level
     * @param name
     * @param nodeList
     * @return
     */
    public static Node isInNode(Node parent,Integer level,String name,List<Node> nodeList){
        if(CollectionUtils.isEmpty(nodeList) || !nodeList.stream().filter(entity->entity.getName().equals(name)).findFirst().isPresent()){
            Node node = new Node(name,level);
            nodeList.add(node);
            if(parent != null) parent.setChildren(nodeList);
            return node;
        }
        return nodeList.stream().filter(entity->entity.getName().equals(name)).findFirst().get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
