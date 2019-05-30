package com.blackfish.java.zk.lock;

import org.apache.curator.utils.ZookeeperFactory;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/29 15:47
 * @Description:
 */
public class ZkDistributeLock implements Lock, Watcher {

    //zk
    private ZooKeeper zk = null;

    //根节点
    private String Root_Lock ="/zkLock";

    //锁的名称
    private String lockName;

    private String currentLock;

    private String waitLock;

    //默认会话超时时间
    private int defaultSessionTimeOut = 30000;

    // 计数器
    private CountDownLatch countDownLatch;

    public ZkDistributeLock(String url,String lockName) {
        this.lockName = lockName;
        try {
            zk = new ZooKeeper(url,defaultSessionTimeOut,this);
            //判断根节点是否存在
            Stat stat  = zk.exists(Root_Lock,false);
            if(null == stat){
                zk.create(Root_Lock,new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lock() {

        if(this.tryLock()){
            System.out.println("获得锁"+lockName);
        }else{
            try {
                waitLock(waitLock);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        try {
            currentLock = zk.create(Root_Lock+"/"+lockName,new byte[0],ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("当前节点"+currentLock);
            //获取当前目录下子节点
            List<String> nodes = zk.getChildren(Root_Lock,false);
            //排序
            Collections.sort(nodes);

            if (currentLock.equals(nodes.get(0))){
                return true;
            }

            for(int j= nodes.size()-1;j>=0;j--){
                if(nodes.get(j).equals(currentLock)){
                    waitLock = nodes.get(j-1);
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void waitLock(String waitLock) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(Root_Lock+waitLock,true);
        if(null != stat){
            //监听等待锁
            System.out.println(Thread.currentThread().getName() + "等待锁 " + Root_Lock + "/" + waitLock);
            this.countDownLatch = new CountDownLatch(1);
            // 计数等待，若等到前一个节点消失，则precess中进行countDown，停止等待，获取锁
            this.countDownLatch.await(defaultSessionTimeOut, TimeUnit.MILLISECONDS);
            this.countDownLatch = null;
            System.out.println(Thread.currentThread().getName() + " 等到了锁");
        }
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        try {
            zk.delete(currentLock,-1);
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
        if (this.countDownLatch != null) {
            this.countDownLatch.countDown();
        }
    }
}
