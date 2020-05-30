package com.blackfish.work;

import com.blackfish.java.util.common.JsonUtil;

import java.util.*;

/**
 * @Auther: SZSS
 * @Date: 2019/6/12 10:04
 * @Description:
 */
public class ShardingTest {

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.home"));
//        long remember = Math.abs(Long.valueOf("15960000001").hashCode()) % 8;
//        System.out.println(remember);
////
//        long account = Math.abs("15960000001".hashCode()) % 8;
//        System.out.println(account);
//
//        //shopNo
//        int dataSource =("1000761".hashCode()%(2*32))/32;
//        System.out.println(dataSource);
//
//        int table = ("1000761".hashCode()%(2*32))%32;
//        System.out.println(table+NumericEnum.ONE.value);
//
//        int dataSource1 =("1000899".hashCode()%(2*32))/32;
//        System.out.println(dataSource1);
//
//        int table1 = ("1000031".hashCode()%(2*32))%32;
//        System.out.println(table1+NumericEnum.ONE.value);

        List<String> list = new ArrayList<>();
        list.add("1001266");

        System.out.println("\u6ca1\u6709\u6743\u9650");

        System.out.println("\u8be5\u8ba2\u5355\u975e\u90e8\u5206\u9000\u6b3e\u8ba2\u5355");
        //1582167521  1582167545



        System.out.println(System.currentTimeMillis() / 1000);

        Set<String> stringSet = new HashSet<>();

        for(String str : list){
            int sharding = Math.abs(str.hashCode()) % 32 + 1;

            int sub = Math.abs(str.hashCode()%64)/32;
            String subss ="";
            if (sub==0) {
                subss=  "01";
            }else if(sub==1){
                subss=  "02";
            }
            String tablePrefix ="snt_stwms_sub_"+subss+".inventory_info_log_";
            String s = String.valueOf(sharding);
            if(s.length()==1){
                s = "00"+s;
            }else{
                s = "0"+s;
            }
            stringSet.add(tablePrefix+s+" where shop_no ='"+str+"'");
            System.out.println(tablePrefix+s+" where shop_no ='"+str+"'");
        }
//        System.out.println(JsonUtil.toJson(stringSet));


//        int sharding1 = Math.abs(("1001165").hashCode()) % 2 + 1;
//        System.out.println(sharding1);

    }
}
