package com.blackfish.springSource.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/28 14:57
 * @Description:
 */
public interface StudentService extends Remote {

    List<Student> getList() throws RemoteException;
}
