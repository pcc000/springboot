package com.blackfish.springSource.bean.propertyedit;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/7 17:37
 * @Description:
 */
public class DatePropertyEditor extends PropertyEditorSupport {

    private String format ="yyyy-MM-dd";

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text){
        SimpleDateFormat ff = new SimpleDateFormat(format);
        try {
            Date d = ff.parse(text);
            this.setValue(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
