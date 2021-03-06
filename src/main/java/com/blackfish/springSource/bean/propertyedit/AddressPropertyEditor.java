package com.blackfish.springSource.bean.propertyedit;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @Auther: shuyiwei
 * @Date: 2021/3/6 10:06
 * @Description:
 */
public class AddressPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) {
        String[] str = value.split("-");
        Address address = new Address();
        address.setProvince(str[0]);
        address.setCity(str[1]);
        address.setCountry(str[2]);
        this.setValue(address);
    }
}
