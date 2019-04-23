package com.blackfish.java.util.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/23 14:57
 * @Description:
 */
public class JackJsonNamingFormat {
    private Set<String> filterFiled = new HashSet(0);
    private Map<String, String> nameFormat = new HashMap(0);

    public JackJsonNamingFormat() {
    }

    public void set(String orgFiledName, String formatFiledName) {
        this.nameFormat.put(orgFiledName, formatFiledName);
    }

    public Map<String, String> getFormatMap() {
        return this.nameFormat;
    }

    public void setFilter(String orgFiledName) {
        this.filterFiled.add(orgFiledName);
    }

    public Set<String> getFilterSet() {
        return this.filterFiled;
    }
}

