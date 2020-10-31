package com.songshu.common;

import java.util.List;


public interface FactoryList<K, E extends MatchingBean<K>> extends List<E> {
    E getBean(K var1);

    <B> List<B> map(Function<E, B> var1);
}
