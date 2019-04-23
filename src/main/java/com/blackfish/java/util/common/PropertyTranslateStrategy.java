package com.blackfish.java.util.common;

import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/23 14:56
 * @Description:
 */
public class PropertyTranslateStrategy extends PropertyNamingStrategy {
    private JackJsonNamingParse jackJsonNamingParse = null;
    private JackJsonNamingFormat jackJsonNamingFormat = null;

    public PropertyTranslateStrategy(JackJsonNamingParse nameParse) {
        this.setJackJsonNamingParse(nameParse);
    }

    public PropertyTranslateStrategy(JackJsonNamingFormat nameFormat) {
        this.setJackJsonNamingFormat(nameFormat);
    }

    public PropertyTranslateStrategy() {
    }

    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return this.serializeProperty(defaultName);
    }

    public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return this.deserializeProperty(defaultName);
    }

    private String deserializeProperty(String input) {
        return this.jackJsonNamingParse != null && this.jackJsonNamingParse.getParseMap().containsKey(input) && this.jackJsonNamingParse.getParseMap() != null ? (String)this.jackJsonNamingParse.getParseMap().get(input) : input;
    }

    private String serializeProperty(String input) {
        if (this.jackJsonNamingFormat != null && this.jackJsonNamingFormat.getFilterSet().contains(input)) {
            return input;
        } else {
            return this.jackJsonNamingFormat != null && this.jackJsonNamingFormat.getFormatMap().containsKey(input) && this.jackJsonNamingFormat.getFormatMap().get(input) != null ? (String)this.jackJsonNamingFormat.getFormatMap().get(input) : input;
        }
    }

    public JackJsonNamingParse getJackJsonNamingParse() {
        return this.jackJsonNamingParse;
    }

    public void setJackJsonNamingParse(JackJsonNamingParse jackJsonNamingParse) {
        this.jackJsonNamingParse = jackJsonNamingParse;
    }

    public JackJsonNamingFormat getJackJsonNamingFormat() {
        return this.jackJsonNamingFormat;
    }

    public void setJackJsonNamingFormat(JackJsonNamingFormat jackJsonNamingFormat) {
        this.jackJsonNamingFormat = jackJsonNamingFormat;
    }
}
