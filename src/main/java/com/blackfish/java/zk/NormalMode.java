package com.blackfish.java.zk;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/20 15:38
 * @Description:
 */
public class NormalMode {

    public static void main(String[] args) throws Exception{

        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181",30000,new TestWatcher());
        Watcher myWatcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("WatchedEvent");
            }
        };
        AsyncCallback.StatCallback existsCallback = new AsyncCallback.StatCallback() {
            @Override
            public void processResult(int i, String s, Object o, Stat stat) {
                System.out.println("processResult");
            }
        };
        zk.exists("/myZnode",myWatcher,existsCallback,null);

        Thread.sleep(100000);

    }

}
