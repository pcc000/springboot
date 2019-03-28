package com.blackfish.springSource.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/28 15:07
 * @Description:
 */
public class SetService {

    public static void main(String[] args) {
        try{
            StudentService studentService = new StudentServiceImpl();
            LocateRegistry.createRegistry(10001);
            Naming.rebind("rmi://127.0.0.1:10001/studentService",studentService);
            System.out.println("Service start");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
