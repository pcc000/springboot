package com.blackfish.work;

/**
 * @Auther: SZSS
 * @Date: 2019/6/12 10:04
 * @Description:
 */
public class ShardingTest {

    public static void main(String[] args) {
        long remember = Math.abs(Long.valueOf("18252059044").hashCode()) % 8;
        System.out.println(remember);

        long account = Math.abs("18252059044".hashCode()) % 8;
        System.out.println(account);

        //shopNo
        int dataSource =("1000761".hashCode()%(2*32))/32;
        System.out.println(dataSource);

        int table = ("1000761".hashCode()%(2*32))%32;
        System.out.println(table+NumericEnum.ONE.value);

        int dataSource1 =("1000899".hashCode()%(2*32))/32;
        System.out.println(dataSource1);

        int table1 = ("1000031".hashCode()%(2*32))%32;
        System.out.println(table1+NumericEnum.ONE.value);

        int sharding = Math.abs(("1000031").hashCode()) % 32 + 1;
        System.out.println(sharding);

        int sharding1 = Math.abs(("3148").hashCode()) % 2 + 1;
        System.out.println(sharding1);

    }
}
