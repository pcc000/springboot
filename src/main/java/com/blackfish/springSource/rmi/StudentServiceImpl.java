package com.blackfish.springSource.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/28 14:58
 * @Description:
 */
public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {


    public StudentServiceImpl() throws RemoteException{

    }

    @Override
    public List<Student> getList() throws RemoteException{
        List<Student> list = new ArrayList<Student>();
        Student s1 = new Student();
        s1.setAge(123);
        s1.setName("sfsa");

        Student s2 = new Student();
        s2.setAge(213);
        s2.setName("sfsfsdf");

        list.add(s1);
        list.add(s2);

        return list;
    }


}
