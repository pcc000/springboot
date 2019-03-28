package com.blackfish.springSource.rmi.spring;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/28 15:29
 * @Description:
 */
public class HelloRMIServiceImpl extends UnicastRemoteObject implements  HelloRMIService {

    public HelloRMIServiceImpl() throws RemoteException{

    }

    @Override
    public int getAdd(int a, int b) throws RemoteException {
        return a+b;
    }
}
