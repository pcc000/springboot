package com.blackfish.java.zk.masterAndSlave;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/21 11:04
 * @Description:
 */
public class Worker implements Watcher {

    private static final Logger LOG = LoggerFactory.getLogger(Worker.class);

    ZooKeeper zk;
    String hostPort;
    Random random = new Random();
    String serverId = Integer.toHexString(random.nextInt());
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        updateStatus(status);
    }

    public Worker(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort,15000,this);
    }

    void register(){
        zk.create("/workers/worker-"+serverId,"Idle".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL,registerCallBack,null);
    }

    AsyncCallback.StringCallback registerCallBack = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int i, String s, Object o, String s1) {
            switch (KeeperException.Code.get(i)){
                case CONNECTIONLOSS:
                    register();
                    break;
                case OK:
                    LOG.info("Registered successfully:"+serverId);
                    break;
                case NODEEXISTS:
                    LOG.warn("Already registered:"+serverId);
                    break;
                default:
                    LOG.error("Somethind went wrong:"+KeeperException.create(KeeperException.Code.get(i),s));
            }
        }
    };

    synchronized private void updateStatus(String status){
        if(status == this.status){
            zk.setData("/workers/"+"111111",status.getBytes(),-1,statusUpdateCallBack,status);
        }
    }

    AsyncCallback.StatCallback statusUpdateCallBack = new AsyncCallback.StatCallback() {
        @Override
        public void processResult(int i, String s, Object o, Stat stat) {
            switch (KeeperException.Code.get(i)){
                case CONNECTIONLOSS:
                    updateStatus((String)o);
                    return;
            }
        }
    };

    public static void main(String[] args) throws Exception {
        Worker worker = new Worker("127.0.0.1:2181");
        worker.startZK();
        worker.register();
        Thread.sleep(300000);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("worker process");
        System.out.println(watchedEvent);
    }
}
