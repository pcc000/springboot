package com.blackfish.springSource.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.xml.XmlValidationModeDetector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/11/6 13:35
 * @Description:
 */
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() throws IOException {
        StringTokenizer st = new StringTokenizer("name,sss;sss1 tt", ",; ");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }


        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("BeanFactory.xml"));
        TestBean test = (TestBean) bf.getBean("test");
        System.out.println(test.getStr());


        Resource resource = new ClassPathResource("BeanFactory.xml");
        InputStream stream = resource.getInputStream();

        XmlValidationModeDetector validationModeDetector = new XmlValidationModeDetector();
        int i = validationModeDetector.detectValidationMode(stream);

        System.out.println(i);

        //--------------------
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String content;
        while((content = reader.readLine())!= null){
            System.out.println(content);
        }
        System.out.println("==================");
        //--------------------
        byte[] b = new byte[1024];
        int len =0;
        int temp =0;
        while((temp=stream.read())!=-1){
            b[len] = (byte)temp;
            len++;
        }
        System.out.println(new String(b,0,len));

    }

}
