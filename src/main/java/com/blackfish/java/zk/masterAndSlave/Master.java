package com.blackfish.java.zk.masterAndSlave;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/20 16:03
 * @Description:
 */
public class Master implements Watcher {

    ZooKeeper zk;
    String hostPort;
    Random random = new Random();
    String serverId = Integer.toHexString(random.nextInt());
    boolean isLeader = false;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort,30000,this);
    }

    void stopZK() throws Exception{
        zk.close();
    }

    boolean checkMaster(){
        while(true){
            try{
                Stat stat = new Stat();
                byte data[] = zk.getData("/master",false,stat);
                isLeader = new String(data).equals(serverId);
                return true;
            }catch (InterruptedException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }
    }

    void runForMaster() throws InterruptedException{
        while(true){
            try {
                System.out.println("serverId:"+serverId);
                zk.create("/master",serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                isLeader = true;                break;
            } catch (KeeperException.NodeExistsException e) {
                isLeader = false;
                break;
            } catch (KeeperException.ConnectionLossException e) {

            } catch (KeeperException e) {
                e.printStackTrace();
            }
            if (checkMaster()) break;
        }
    }

    void runForMasters() throws Exception{
        zk.create("/master",serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,masterCreateCallback,null);
    }

     AsyncCallback.StringCallback masterCreateCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int i, String s, Object o, String s1) {
            switch (KeeperException.Code.get(i)){
                case CONNECTIONLOSS:
                    checkMaster();
                    return;
                case OK:
                    isLeader = true;
                    break;
                default:
                    isLeader = false;
            }
            System.out.println("masterCreateCallback:");
            System.out.println("I am "+(isLeader?" ":"not ")+" the leader");
        }
    };

    void checkMasters(){
        zk.getData("/master",false,masterCheckCallback,null);
    }

    AsyncCallback.DataCallback masterCheckCallback = new AsyncCallback.DataCallback() {
        @Override
        public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
            switch (KeeperException.Code.get(i)){
                case CONNECTIONLOSS:
                    checkMasters();
                    return;
                case NONODE:
                    try {
                        runForMasters();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
            }
        }
    };

    public void bootStrap(){
        createParent("/workers",new byte[0]);
        createParent("/tasks",new byte[0]);
        createParent("/assign",new byte[0]);
    }

    void createParent(String path,byte[] data){
        zk.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT,createParentCallback,data);
    }

    AsyncCallback.StringCallback createParentCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int i, String s, Object o, String s1) {
            switch (KeeperException.Code.get(i)){
                case CONNECTIONLOSS:
                    createParent(s,(byte[])o);
                    break;
                case OK:
                    System.out.println("parent created");
                    break;
                case NODEEXISTS:
                    System.out.println("parent alreay registered:"+s);
                default:
                    System.out.println("Something went wrong:"+KeeperException.create(KeeperException.Code.get(i),s));

            }
        }
    };

    public static void main(String[] args) throws Exception {
        Master m = new Master("127.0.0.1:2181");
        m.startZK();
//        Thread.sleep(60000);
//        m.stopZK();
        m.runForMasters();
        if(m.isLeader){
            System.out.println("I am the leader");
            Thread.sleep(60000);
        }else{
            Thread.sleep(60000);
            System.out.println("Someone else is the leader");
        }
        m.stopZK();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("master watcher");
        System.out.println(watchedEvent);
    }
}
