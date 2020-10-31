package com.songshu.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class FactoryListEditor extends CustomCollectionEditor {
    public FactoryListEditor() {
        super(FactoryArrayList.class);
        this.addPropertyChangeListener(new FactoryListEditor.InitializingBeanListener());
    }

    private class InitializingBeanListener implements PropertyChangeListener {
        private InitializingBeanListener() {
        }

        public void propertyChange(PropertyChangeEvent evt) {
            Object value = ((FactoryListEditor)evt.getSource()).getValue();
            if (value instanceof InitializingBean) {
                try {
                    ((InitializingBean)value).afterPropertiesSet();
                } catch (Exception var4) {
                    throw new RuntimeException("初始化bean afterPropertiesSet异常", var4);
                }
            }

        }
    }
}