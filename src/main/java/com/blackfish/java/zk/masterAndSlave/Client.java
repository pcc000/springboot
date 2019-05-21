package com.blackfish.java.zk.masterAndSlave;

import org.apache.zookeeper.*;

import java.util.Random;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/21 13:41
 * @Description:
 */
public class Client implements Watcher {

    ZooKeeper zk;
    String hostPort;

    public Client(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws Exception{
        zk = new ZooKeeper(hostPort,15000,this);
    }

    String queueCommand(String command){
        while(true){
            try{
                String name = zk.create("/tasks/task-",command.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL);
                return name;
            }catch(KeeperException.NodeExistsException e){

            }catch (KeeperException.ConnectionLossException e){

            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) throws Exception {
        Client c = new Client("127.0.0.1:2181");
        c.startZK();
        String name = c.queueCommand("1");
        System.out.println("Created "+name);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Client process");
        System.out.println(watchedEvent);
    }
}
