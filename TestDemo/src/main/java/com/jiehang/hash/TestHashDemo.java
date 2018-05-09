package com.jiehang.hash;

import java.util.HashMap;
import java.util.Map;

public class TestHashDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(map.toString());
        System.out.println(map.size());
    }
}
