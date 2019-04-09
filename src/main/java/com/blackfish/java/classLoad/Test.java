package com.blackfish.java.classLoad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/1/8 10:56
 * @Description:
 */
public class Test {
    public static void main(String arg[]){
        new Son();
        System.out.println("-----------------");
        new Son();


        Map<String,String> map = new HashMap<String,String>();
        map.put("1","pcc");
        map.put("2","sfsd");
        map = Collections.unmodifiableMap(map);

        System.out.println(map.get("1"));
    }
}
