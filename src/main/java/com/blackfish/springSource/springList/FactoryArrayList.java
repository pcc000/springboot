package com.blackfish.springSource.springList;

import java.lang.reflect.Method;
import java.util.*;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.OrderComparator;

public class FactoryArrayList extends ArrayList implements FactoryList, InitializingBean {

    public MatchingBean getBean(Object factor) {
        Iterator itr = iterator();
        do {
            if (!itr.hasNext())
                break;
            MatchingBean beanMatch = (MatchingBean) itr.next();
            try {
                if (beanMatch.matching(factor))
                    return beanMatch;
            } catch (ClassCastException e) {
                try {
                    Method matching = beanMatch.getClass().getMethod("matching", new Class[]{
                            factor.getClass()
                    });
                    Boolean matched = (Boolean) matching.invoke(beanMatch, new Object[]{
                            factor
                    });
                    if (matched.booleanValue())
                        return beanMatch;
                } catch (Exception e1) {
                    throw new RuntimeException("try matching method error", e1);
                }
            }
        } while (true);
        return null;
    }

    public void afterPropertiesSet()
            throws Exception {
        if (!isEmpty()) {
            Object a[] = toArray();
            OrderComparator.sort(a);
            ListIterator i = listIterator();
            for (int j = 0; j < a.length; j++) {
                i.next();
                i.set(a[j]);
            }

        }
    }

    public List map(Function func) {
        List ret = new ArrayList();
        Iterator itr = iterator();
        do {
            if (!itr.hasNext())
                break;
            MatchingBean service = (MatchingBean) itr.next();
            Object result = func.invoking(service);
            if (result != null)
                ret.add(result);
        } while (true);
        return ret;
    }

    private static final long serialVersionUID = 0x4f2d72ae10eed1f1L;
}
