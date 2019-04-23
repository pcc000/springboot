package com.blackfish.java.util.common;

import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/23 14:58
 * @Description:
 */
public class UnderlineFilterStrategy extends PropertyNamingStrategy {
    private Set<String> filterSet = new HashSet();

    public UnderlineFilterStrategy() {
    }

    public UnderlineFilterStrategy(Set<String> filterSet) {
        this.setFilterSet(filterSet);
    }

    public String nameForGetterMethod(MapperConfig config, AnnotatedMethod method, String defaultName) {
        return config != null && config instanceof SerializationConfig && this.filterSet.contains(defaultName) ? defaultName : this.convert(defaultName);
    }

    public String nameForSetterMethod(MapperConfig config, AnnotatedMethod method, String defaultName) {
        return this.convert(defaultName);
    }

    private String convert(String input) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        for(int len = input.length(); i < len; ++i) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append('_');
                c = Character.toLowerCase(c);
            }

            result.append(c);
        }

        return result.toString();
    }

    public Set<String> getFilterSet() {
        return this.filterSet;
    }

    public void setFilterSet(Set<String> filterSet) {
        this.filterSet = filterSet;
    }
}
