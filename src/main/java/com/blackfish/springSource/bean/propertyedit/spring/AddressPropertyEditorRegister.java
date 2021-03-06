package com.blackfish.springSource.bean.propertyedit.spring;

import com.blackfish.springSource.bean.propertyedit.AddressPropertyEditor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import com.blackfish.springSource.bean.propertyedit.Address;


/**
 * @Auther: shuyiwei
 * @Date: 2021/3/6 15:10
 * @Description:
 */
public class AddressPropertyEditorRegister implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        propertyEditorRegistry.registerCustomEditor(Address.class, new AddressPropertyEditor());
    }
}
