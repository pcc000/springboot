package com.blackfish.java.redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/27 22:17
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.106");
        System.out.println(jedis.ping());
        System.out.println(jedis.get("pcc"));
    }
}
