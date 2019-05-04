package com.blackfish.java.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/3 16:02
 * @Description:
 */
public class App {

    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181",30000,new TestWatcher());

        List<String> lists = zk.getChildren("/",new TestWatcher());
        System.out.println("/ children:"+lists.toString());

        String nodes ="/node2";
        Stat stat = zk.exists(nodes,false);
        if(null == stat){
            String createResult = zk.create(nodes,"test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        byte[] b = zk.getData(nodes,false,stat);
        System.out.println(new String(b));
        zk.close();
    }
}

class TestWatcher implements Watcher{
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("-------------------------");
        System.out.println("path:"+watchedEvent.getPath());
        System.out.println("type:"+watchedEvent.getType());
        System.out.println("state:"+watchedEvent.getState());
        System.out.println("-------------------------");
    }
}
