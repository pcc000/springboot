package com.blackfish.java.util.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/23 14:57
 * @Description:
 */
public class JackJsonNamingParse {
    private Map<String, String> nameParse = new HashMap(0);

    public JackJsonNamingParse() {
    }

    public void set(String orgFiledName, String parseFiledName) {
        this.nameParse.put(orgFiledName, parseFiledName);
    }

    public Map<String, String> getParseMap() {
        return this.nameParse;
    }
}
