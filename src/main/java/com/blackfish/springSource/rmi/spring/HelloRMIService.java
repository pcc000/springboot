package com.blackfish.springSource.rmi.spring;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/28 15:29
 * @Description:
 */
public interface HelloRMIService extends Remote {

    public int getAdd(int a,int b) throws RemoteException;

    public String sayHello(String name) throws RemoteException;
}
