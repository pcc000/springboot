package com.songshu.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.OrderComparator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FactoryArrayList<K, E extends MatchingBean<K>> extends ArrayList<E> implements FactoryList<K, E>, InitializingBean {
    private static final long serialVersionUID = 5705342394882249201L;

    public FactoryArrayList() {
    }

    public FactoryArrayList(int size) {
        super(size);
    }

    public E getBean(K factor) {
        Iterator itr = this.iterator();

        while(itr.hasNext()) {
            MatchingBean beanMatch = (MatchingBean)itr.next();

            try {
                if (beanMatch.matching(factor)) {
                    return (E) beanMatch;
                }
            } catch (ClassCastException var8) {
                try {
                    Method matching = beanMatch.getClass().getMethod("matching", factor.getClass());
                    Boolean matched = (Boolean)matching.invoke(beanMatch, factor);
                    if (matched) {
                        return (E)beanMatch;
                    }
                } catch (Exception var7) {
                    throw new RuntimeException("try matching method error", var7);
                }
            }
        }

        return null;
    }

    public void afterPropertiesSet() throws Exception {
        if (!this.isEmpty()) {
            Object[] a = this.toArray();
            OrderComparator.sort(a);
            ListIterator i = this.listIterator();

            for(int j = 0; j < a.length; ++j) {
                i.next();
                i.set(a[j]);
            }
        }

    }

    public <B> List<B> map(Function<E, B> func) {
        List<B> ret = new ArrayList();
        Iterator itr = this.iterator();

        while(itr.hasNext()) {
            E service = (E) itr.next();
            B result = func.invoking(service);
            if (result != null) {
                ret.add(result);
            }
        }

        return ret;
    }
}

