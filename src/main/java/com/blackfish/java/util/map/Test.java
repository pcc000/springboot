package com.blackfish.java.util.map;

import org.springframework.util.LinkedMultiValueMap;

import java.util.*;

/**
 * @Auther: BETA
 * @Date: 2021/9/16 19:40
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        List<String>  a = Arrays.asList("111","222","333","444");
        List<String> as = Arrays.asList("123","111");

        LinkedMultiValueMap result = new LinkedMultiValueMap();
        result.addAll("a",a);
        result.addAll("a",as);
        List<String> result1 = (List)result.getOrDefault("a",Collections.emptyList());
        Set<String> set =new LinkedHashSet<>(result1);


        System.out.println(result);

        System.out.println(set);
    }
}
