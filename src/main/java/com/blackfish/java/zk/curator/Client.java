package com.blackfish.java.zk.curator;

import com.tiefan.infra.zk.ZkReentrantLock;
import org.apache.curator.RetryPolicy;
import org.apache.curator.RetrySleeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/29 14:59
 * @Description:
 */
public class Client {

    public static void main(String[] args) throws  Exception{

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework zkc = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);

        zkc.start();

        zkc.create().withMode(CreateMode.PERSISTENT).forPath("/myPath","pcc".getBytes());

        ZkReentrantLock lock = new ZkReentrantLock("lockName");

        lock.lock();
    }
}
