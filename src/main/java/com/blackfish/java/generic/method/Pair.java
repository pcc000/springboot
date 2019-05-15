package com.blackfish.java.generic.method;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/7 10:25
 * @Description:
 */
public class Pair<K,V> {

    private K key;

    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
