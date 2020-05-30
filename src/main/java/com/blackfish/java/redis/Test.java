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
        Jedis jedis = new Jedis("127.0.0.1",6379);
//        System.out.println(jedis.ping());
        jedis.set("pcc", "213");

//        jedis.sscan()
        System.out.println(jedis.get("pcc"));
    }
}
