package com.blackfish.springSource.springList;

import java.util.List;

public interface FactoryList extends List {

    public abstract MatchingBean getBean(Object obj);

    public abstract List map(Function function);
}
