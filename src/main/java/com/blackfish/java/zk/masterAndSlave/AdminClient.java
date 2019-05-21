package com.blackfish.java.zk.masterAndSlave;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Date;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/21 16:47
 * @Description:
 */
public class AdminClient implements Watcher {

    ZooKeeper zk;
    String hostPort;

    public AdminClient(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    void listState() throws KeeperException, InterruptedException {
        try {
            Stat stat = new Stat();
            byte masterData[] = zk.getData("/master", false, stat);
            Date startDate = new Date(stat.getCtime());
            System.out.println("Master: " + new String(masterData) + " since " + startDate);
        } catch (KeeperException.NoNodeException e){
                System.out.println("No master");
        }catch (Exception e) {

        }
        System.out.println("Workers:");
        for(String w: zk.getChildren("/workers",false)){
            byte data[] = zk.getData("/workers/"+w,false,null);
            String state = new String(data);
            System.out.println(w+" :"+state);
        }
        System.out.println("Tasks:");
        for(String t:zk.getChildren("/assign",false)){
            System.out.println(t);
        }
    }

    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        AdminClient c = new AdminClient("127.0.0.1:2181");
        c.startZK();
        c.listState();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("AdminClient process");
        System.out.println(watchedEvent);
    }
}
