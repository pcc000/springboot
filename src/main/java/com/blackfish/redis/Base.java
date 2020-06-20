package com.blackfish.redis;

import com.blackfish.java.util.common.JsonUtil;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class Base {

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        String result = jedis.hget("car1","color");
        Map<String, String> allMap = jedis.hgetAll("car");
        System.out.println(result);
        System.out.println(JsonUtil.toJson(allMap));
        jedis.del("count");

        //hyperLoglog
        for(int i=0;i<100;i++){
            jedis.pfadd("count","user");
        }
        long total = jedis.pfcount("count");
        System.out.println("100 ," + total);
        jedis.close();
    }

}
