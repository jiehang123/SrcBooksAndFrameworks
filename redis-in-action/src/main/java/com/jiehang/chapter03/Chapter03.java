package com.jiehang.chapter03;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class Chapter03 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.select(5);
        System.out.println(jedis);
        jedis.lpush("jiehang", "ok");
    }

}
