package com.blackfish.springSource.rmi;

import java.rmi.Naming;
import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/28 15:11
 * @Description:
 */
public class GetService {

    public static void main(String[] args) {
        try{
            StudentService sudentService = (StudentService) Naming.lookup("rmi://127.0.0.1:10001/studentService");
            List<Student> list = sudentService.getList();
            for(Student s : list){
                System.out.println(s);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
